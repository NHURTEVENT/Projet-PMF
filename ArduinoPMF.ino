#include "DHT.h"
#include "stdlib.h"
#define DHTPIN 2 // Pin où on connecte la DHT
#define DHTTYPE DHT22 // on définit qu'on utilise une DHT22

int incomingByte = 0;
String data = "";

DHT dht(DHTPIN, DHTTYPE);
//coef Steinhart hart
float a = 0.00088386;
float b = 0.0002583;
float c = 1.1661 * pow(10, -7);

//taux d'humidité
float h = 0.0;
float temperatureInt = 0.0;
float temperatureExt = 0.0;
int consigne = 18;


void setup() {
  //on commence la transmission série
  Serial.begin(9600);
  //On commence la lecture DHT
  dht.begin();
}

void loop() {
  //on récupère l'humidité
  h = dht.readHumidity();

  //On test si il y a risque de condensation
  //et s'il y en a on éteint le Peltier
  testHumidite(h);

  //calcul point de rosée
  // K = 237.7* tempInt /(17.7+ tempInt) + log(tauxHumi)
  //en arduino log = ln donc pour obtenir log on fait ln(x)/ln(10)
  float coefRosee = (237.7 * temperatureInt) / (17.7 + temperatureInt) + log(h) / log(10);
  float TRosee = 237.7 * coefRosee / (17.7 - coefRosee);

  //Lecture température de la DHT, non utilisée mais toujours utile
  float t = dht.readTemperature();

  //on calcule la tension du pont diviseur
  float tension = analogRead(0) * 5.0 / 1024.0;

  //on peut alors calculer la résistance de la thermistance
  float resistance = tension * 10000.0 / (5.0 - tension); //R2 = U*R1/(U-U2)

  //On peut donc calculer la témpérature
  temperatureInt = (float) 1 / (a + b * log(resistance) + c * pow(log(resistance), 3));
  temperatureInt -= 273.15;

  //On convertit les floats en string pour les écrire sur le port série
  char buffTemperature[25];
  dtostrf(temperatureInt, 4, 1, buffTemperature);
  String strTemperature(buffTemperature);

  char buffHumidite[25];
  dtostrf(h, 4, 1, buffHumidite);
  String strHumi(buffHumidite);

  //On convertit la consigne (un int) en string pour l'écrire sur le port série
  String strConsigne = "";
  strConsigne += consigne;

  //On créé la string contenant toutes les info a transmettre
  String toSend = strTemperature + "_" + strTemperature + "_" + strTemperature + "_" + strHumi + "_" + strConsigne + "_;";
  //On la convertit en tableau de char pour pouvoir l'envoyer
  char toBeSent[50];
  toSend.toCharArray(toBeSent, 50);

  //On vérifie qu'on reçoit des données
  if (Serial.available() > 0) {

    //On lit le port série
    String str = Serial.readString();

    //Si on reçoit une demande d'update
    if (str.equals("updt")) {

      //On transmet les données
      Serial.println(toBeSent);
    } else {

      //On convertit la string reçue en tableau de char
      //pour pouvoir la strtok
      uint8_t buf[50];
      str.toCharArray(buf, 50);

      //On supprime une éventuellement demande de mise à jour
      //On ne devrait jamais en avoir mais j'ai déjà rencontré ce problème
      String truc = strtok(buf, "updt");

      uint8_t buf3[50];
      truc.toCharArray(buf3, 50);

      if (strcspn(buf3, "c") == 0) {

        String truc2 = "";
        truc2 += strtok(buf3, "c");
        consigne = truc2.toInt();
      }
    }
  }
  //Voir si on peut le supppr
  delay(2000);

}

//Afin d'éviter la condensation on coupe le module si
//le taux d'humidité dépasse 90%
void testHumidite(float h) {
  if (h > 90) {
    digitalWrite(8, LOW);
  } else {
    digitalWrite(8, HIGH);
  }
}

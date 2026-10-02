import java.util.Scanner;
import java.util.Random;
public class Main {

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
boolean jugarDeNuevo = true;
while (jugarDeNuevo) {

int agua = 100;
int comida = 100;
int energia = 100;
int oro = 20;
int dia = 1;
boolean derrota = false;
System.out.println("------------------------------------------------");
System.out.println("¡Bienvenido al Reto del Explorador de Navolato!");
System.out.println("Debes sobrevivir 10 días para llegar a Tecate.");
System.out.println("------------------------------------------------\n");

while (dia <= 10 && !derrota) {
boolean opcionValida = false;
int opcion = 0;

while (!opcionValida) {
System.out.println("-- DÍA " + dia + " --");
System.out.println("Agua: " + agua + " | Comida: " + comida + " | Energía: " + energia + " | Oro: " + oro);
System.out.println("Elige una opción:");
System.out.println("1. Explorar (buscar oro, te va dar hambre sed y te cansas, AGUAS)");
System.out.println("2. Descansar (recupera energía, FLOJO )");
System.out.println("3. Racionar (ahorra recursos, AGUANTALA )");
System.out.println("4. Comprar en walmart (o algo asi) cercano");
System.out.print("Opción: ");

if (scanner.hasNextInt()) {
opcion = scanner.nextInt();
if (opcion >= 1 && opcion <= 4) {

if (opcion == 4 && oro < 10) {
System.out.println("\n-> No tienes suficiente oro (requieres al menos 10 de oro, POBRE).\n");
} else {
opcionValida = true;
}
} else {

System.out.println("\n-> Opción inválida. Elige un número del 1 al 4.\n");
}
} else {
System.out.println("\n-> Entrada inválida. Debes ingresar un número entero.\n");
scanner.next(); 
}
}

switch (opcion) {
case 1:
agua -= 15;
comida -= 10;
energia -= 20;
int oroEncontrado = random.nextInt(16);



oro += oroEncontrado;
System.out.println("\nEncontraste " + oroEncontrado + " de oro mientras explorabas.");

if (random.nextDouble() < 0.30) {
energia -= 10;
System.out.println("Una manada de avestruces te sorprendió, Perdiste 10 de energía extra.");
}
break;
case 2: 
agua -= 10;
comida -= 10;
energia += 25;
System.out.println("\nHas descansado y recuperado energía.");
break;
case 3:
agua -= 5;
comida -= 5;
energia -= 5;
System.out.println("\nDecidiste racionar tus recursos hoy.");
break;

case 4: 
boolean eleccionValida = false;
while (!eleccionValida) {
System.out.println("\nOasis: Canjea 10 de oro por +20 de un recurso.");
System.out.println("1. +20 Agua");

System.out.println("2. +20 Comida");
System.out.print("Elige una opción: ");
if (scanner.hasNextInt()) {
int eleccion = scanner.nextInt();
if (eleccion == 1) {
oro -= 10;
agua += 20;
System.out.println("Compraste +20 de agua.");
eleccionValida = true;
} else if (eleccion == 2) {
oro -= 10;
comida += 20;
System.out.println("Compraste +20 de comida.");
eleccionValida = true;
} else {
System.out.println("Opción inválida. Elige 1 para Agua o 2 para Comida.");
}
} else {
System.out.println("Entrada inválida. Ingresa 1 o 2.");
scanner.next();
}
}
break;
}




if (agua > 100) agua = 100;
if (comida > 100) comida = 100;
if (energia > 100) energia = 100;
if (agua < 0) agua = 0;
if (comida < 0) comida = 0;
if (energia < 0) energia = 0;
if (agua == 0 || comida == 0 || energia == 0) {
derrota = true;
String recursoAgotado = "";
if (agua == 0) recursoAgotado = "agua";
else if (comida == 0) recursoAgotado = "comida";
else if (energia == 0) recursoAgotado = "energía";
System.out.println("\n--------------------------------------------------");
System.out.println("Has muerto en el Limon de los Ramos en el día " + dia + ".");

System.out.println("Se te agotó la/el " + recursoAgotado + ".");
System.out.println("--------------------------------------------------\n");
} else {
System.out.println("Estado final - Agua: " + agua + " | Comida: " + comida + " | Energía: " + energia + " |Oro: " + oro);

System.out.println("--------------------------------------------------\n");
dia++;
}
}

if (!derrota && dia > 10) {
int puntaje = (agua + comida + energia) + (oro * 2);
System.out.println("\n--------------------------------------------");
System.out.println(" ¡Llegaste a Tecate! ");
System.out.println("Completaste exitosamente los 10 días de viaje.");
System.out.println("Tu puntaje final es: " + puntaje);
System.out.println("--------------------------------------------\n");
}

boolean respuestaValida = false;
while (!respuestaValida) {
System.out.print("Deseas jugar de nuevo? (Si/No): ");
String respuesta = scanner.next().trim().toUpperCase();
if (respuesta.equals("Si")) {
respuestaValida = true;
jugarDeNuevo = true;
System.out.println("\nReiniciando juego\n");
} else if (respuesta.equals("N")) {
respuestaValida = true;
jugarDeNuevo = false;
System.out.println("\nGracias por jugar. Hasta la próxima");
} else {
System.out.println("Respuesta inválida. Ingresa 'Si' para sí o 'No' para no.");
}
}
}
scanner.close();
}
}
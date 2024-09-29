#include <iostream>
#include <cmath>
using namespace std;

void operaNumeros(){
    double num1, num2;
    string key;

    cout << "Inserte dos valores numéricos" << endl;
    cin >> num1;
    cin >> num2;

    cout << "\nAhora seleccione una opción:" << endl;
    cout << "<1> para restar ambos números insertados" << endl;
    cout << "<2> para sumar ambos números insertados" << endl;
    cout << "<3> para multiplicar ambos números seleccionados" << endl;
    cout << "Inserte la letra en mayúsculas\n" << endl;
    cin >> key;

    switch (stoi(key)){
    case 1:
        cout << "La resta es igual a " << num1-num2 << endl;
        break;

    case 2:
        cout << "La suma es igual a " << num1+num2 << endl;
        break;

    case 3:
        cout << "La multiplicación es igual a " << num1*num2 << endl;
        break;
    
    default:
        cout << "La opción no aplica";
        break;
    }
}

void numeroImpar(){
    int num;
    bool flag = false;

    while(!flag){
        cout << "\nInserte un número impar" << endl;
        cout << "Esta instrucción se repetirá hasta que se inserte un número impar\n" << endl;
        cin >> num;

        if(num%2 == 1) {
            flag = true;
            cout << num << " es un número impar!" << endl;
        } else {
            cout << num << " no es un número impar!" << endl;
        }
    }
}

void sumaPares(){
    int suma;

    for(int i = 0; i<=100; i++){
        if (i%2 == 0){
            suma += i;
        }
    }

    cout << "La suma de los números pares del 0 al 100 es " << suma << endl;
}

void mediaAritmetica(){
    double suma = 0;
    int x = 0;
    double n;

    cout << "Inserte la cantidad de números con la que realizará la media aritmética" << endl;
    cin >> x;
    if(x<0){
        cout << "Ese no es un número válido" << endl;
    } else {
        for(int i = x; i>0; i--){
            cout << "\nInserte un número" << endl;
            cin >> n;
            suma += n;
        }

        double mediaArit = suma/x;
        cout << "\nLa media aritmética de los números insertados es " << mediaArit << endl;
    }
}

void numeroMagico(){
    int randNum = rand()%100;
    int guess;
    int tryNum = 0;
    bool flag = false;

    cout << "Inserte un número entero entre 0 y 100 para advinar el valor mágico";

    while(!flag){
        tryNum++;
        cin >> guess;

        if(guess>randNum) {
            cout << "MENOS\n" << endl;
        } else if(guess<randNum) {
            cout << "MÁS\n" << endl;
        } else {
            cout << "Acertaste con el valor mágico " << randNum << " después de " << tryNum << " intentos" << endl;
            flag = true;
        }
    }
}

void conversionCelsiusFarenheit(){
    double initialValue = 0;
    int conversionNum = 0;
    double increment = 0;

    cout << "Esta instrucción convierte una tabla de valores ingresados en Celsius a Farenheit" << endl;
    cout << "Inserte un valor inicial en grados Celsius" << endl;
    cin >> initialValue;
    cout << "\nAhora inserte el número de conversiones que se harán" << endl;
    cin >> conversionNum;
    cout << "\nFinalmente inserte el incremento entre los valores Celsius" << endl;
    cin >> increment;

    cout << "Conversión de grados Celsius a Farenheit" << endl;
    cout << "    FARENHEIT \t\t CELSIUS" << endl;
    for(int i = 0; i<conversionNum; i++){
        double farenheit = (9.0/5.0)*(initialValue+i*increment)+32;
        cout << "    " << farenheit << "°F \t\t " << initialValue + i*increment << "°C" << endl;
    }
}

void serieAritmetica(){
    double a = rand()%100;
    double d = rand()%50;
    int n = rand()%25;
    double suma = 0;

    cout << "El siguiente método imprimira la serie aritmética de " << n << " términos," << endl;
    cout << "comenzando desde un valor inicial " << a << " con una diferencia de " << d << "\n" << endl;

    for(int i = 0; i<n; i++){
        double termino = a + i*d;
        suma += termino;

        cout << "Término " << i+1 << ": " << termino << endl;
    }

    cout << "Valor total de la serie: " << suma << endl;
}

void mediasGeometricaArmonica(){
    cout << "Este método calcula la media geométrica y armónica de los números insertados" << endl;
    cout << "A continuación ingrese cuantos números quiera para calcular estos valores, si desea detenerse, ingrese 0" << endl;

    int n = 0;
    double geometricaTemp = 1;
    double armonicaTemp = 0;
    double entryValue = 1;
    bool flag = true;

    while(flag){
        cout << "\nIngrese un valor numérico" << endl;
        cin >> entryValue;

        if(entryValue > 0){
            n++;
            geometricaTemp *= entryValue;
            armonicaTemp += 1.0/entryValue;

            cout << geometricaTemp << " " << armonicaTemp << endl;
        } else {
            flag = false;
        }
    }

    cout << "La media geométrica de los números insertados es " << pow(geometricaTemp, 1.0/n) << endl;
    cout << "La media armónica de los números insertados es " << n/armonicaTemp << endl;
}

int main(){
    /*operaNumeros();
    numeroImpar();
    sumaPares();
    mediaAritmetica();
    numeroMagico();
    conversionCelsiusFarenheit();
    serieAritmetica();*/
    mediasGeometricaArmonica();
    return 0;
}
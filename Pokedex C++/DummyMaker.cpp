#include "DummyMaker.h"

using namespace std;

DummyMaker::DummyMaker() {
    this->name = "Unknown";        
    this->generation = "Unknown";  
    this->status = "Healthy";       
    this->type1 = "Normal";        
    this->type2 = "";               
    this->height = 0.0;            
    this->weight = 0.0;            
    this->hp = 10;                  
    this->defense = 10;             
    this->speed = 10; 
}

DummyMaker::DummyMaker(string name, string generation, string status, string type1, string type2, 
                       double height, double weight, int hp, int defense, int speed) {
    this->name = name;
    this->generation = generation;
    this->status = status;
    this->type1 = type1;
    this->type2 = type2;
    this->height = height;
    this->weight = weight;
    this->hp = hp;
    this->defense = defense;
    this->speed = speed;
}

string DummyMaker::getName() {
    return name;
}

string DummyMaker::getGeneration() {
    return generation;
}

string DummyMaker::getStatus() {
    return status;
}

string DummyMaker::getType1() {
    return type1;
}

string DummyMaker::getType2() {
    return type2;
}

double DummyMaker::getHeight() {
    return height;
}

double DummyMaker::getWeight() {
    return weight;
}

int DummyMaker::getHp() {
    return hp;
}

int DummyMaker::getDefense() {
    return defense;
}

int DummyMaker::getSpeed() {
    return speed;
}

void DummyMaker::setHp(int hp) {
    if(hp < 0) { hp = 0; }
    this->hp = hp;
}

void DummyMaker::printPokemon() {
    cout << "\nEl Pokemón que introdujo tiene las siguientes características ->" << endl;
    cout << "Nombre: " << getName() << endl;
    cout << "Generación: " << getGeneration() << endl;
    cout << "Rareza: " << getStatus() << endl;
    cout << "Tipo 1: " << getType1() << endl;
    cout << "Tipo 2: " << getType2() << endl;
    cout << "Altura: " << getHeight() << " m" << endl;
    cout << "Peso: " << getWeight() << " kg" << endl;
    cout << "HP: " << getHp() << endl;
    cout << "Defensa: " << getDefense() << endl;
    cout << "Velocidad: " << getSpeed() << endl;
}
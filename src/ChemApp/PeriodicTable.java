package ChemApp;

import java.util.ArrayList;
public class PeriodicTable{
    private Element element;
    private ArrayList<Element> elements = new ArrayList<>();
    public PeriodicTable(){
        //Add all elements
        elements.add(element = new Element ("Hydrogen","H",1,1.0079));
        elements.add(element = new Element ("Helium","He",2,4.0026));
        elements.add(element = new Element ("Lithium","Li",3,6.941));
        elements.add(element = new Element ("Beryllium","Be",4,9.0122));
        elements.add(element = new Element ("Boron","B", 5,10.811));
        elements.add(element = new Element ("Carbon","C", 6,12.0107));
        elements.add(element = new Element ("Nitrogen","N", 7,14.0067));
        elements.add(element = new Element ("Oxygen","O", 8,15.9994));
        elements.add(element = new Element ("Fluorine","F", 9,18.9984));
        elements.add(element = new Element ("Neon","Ne",10,20.1797));
        elements.add(element = new Element ("Sodium","Na",11,22.9897));
        elements.add(element = new Element ("Magnesium","Mg",12,24.305));
        elements.add(element = new Element ("Aluminum","Al",13,26.9815));
        elements.add(element = new Element ("Silicon","Si",14,28.0855));
        elements.add(element = new Element ("Phosphorus","P", 15,30.9738));
        elements.add(element = new Element ("Sulfur","S", 16,32.065));
        elements.add(element = new Element ("Chlorine","Cl",17,35.453));
        elements.add(element = new Element ("Argon","Ar",18,39.948));
        elements.add(element = new Element ("Potassium","K", 19,39.0983));
        elements.add(element = new Element ("Calcium","Ca",20,40.078));
        elements.add(element = new Element ("Scandium","Sc",21,44.9559));
        elements.add(element = new Element ("Titanium","Ti",22,47.867));
        elements.add(element = new Element ("Vanadium","V", 23,50.9415));
        elements.add(element = new Element ("Chromium","Cr",24,51.9961));
        elements.add(element = new Element ("Manganese","Mn",25,54.938));
        elements.add(element = new Element ("Iron","Fe",26,55.845));
        elements.add(element = new Element ("Cobalt","Co",27,58.9332));
        elements.add(element = new Element ("Nickel","Ni",28,58.6934));
        elements.add(element = new Element ("Copper","Cu",29,63.546));
        elements.add(element = new Element ("Zinc","Zn",30,65.39));
        elements.add(element = new Element ("Gallium","Ga",31,69.723));
        elements.add(element = new Element ("Germanium","Ge",32,72.64));
        elements.add(element = new Element ("Arsenic","As",33,74.9216));
        elements.add(element = new Element ("Selenium","Se",34,78.96));
        elements.add(element = new Element ("Bromine","Br",35,79.904));
        elements.add(element = new Element ("Krypton","Kr",36,83.8));
        elements.add(element = new Element ("Rubidium","Rb",37,85.4678));
        elements.add(element = new Element ("Strontium","Sr",38,87.62));
        elements.add(element = new Element ("Yttrium","Y", 39,88.9059));
        elements.add(element = new Element ("Zirconium","Zr",40,91.224));
        elements.add(element = new Element ("Niobium","Nb",41,92.9064));
        elements.add(element = new Element ("Molybdenum","Mo",42,95.94));
        elements.add(element = new Element ("Technetium","Tc",43,98));
        elements.add(element = new Element ("Ruthenium","Ru",44,101.07));
        elements.add(element = new Element ("Rhodium","Rh",45,102.9055));
        elements.add(element = new Element ("Palladium","Pd",46,106.42));
        elements.add(element = new Element ("Silver","Ag",47,107.8682));
        elements.add(element = new Element ("Cadmium","Cd",48,112.411));
        elements.add(element = new Element ("Indium","In",49,114.818));
        elements.add(element = new Element ("Tin","Sn",50,118.71));
        elements.add(element = new Element ("Antimony","Sb",51,121.76));
        elements.add(element = new Element ("Tellurium","Te",52,127.6));
        elements.add(element = new Element ("Iodine","I", 53,126.9045));
        elements.add(element = new Element ("Xenon","Xe",54,131.293));
        elements.add(element = new Element ("Cesium","Cs",55,132.9055));
        elements.add(element = new Element ("Barium","Ba",56,137.327));
        elements.add(element = new Element ("Lanthanum","La",57,138.9055));
        elements.add(element = new Element ("Cerium","Ce",58,140.116));
        elements.add(element = new Element ("Praseodymium","Pr",59,140.9077));
        elements.add(element = new Element ("Neodymium","Nd",60,144.24));
        elements.add(element = new Element ("Promethium","Pm",61,145));
        elements.add(element = new Element ("Samarium","Sm",62,150.36));
        elements.add(element = new Element ("Europium","Eu",63,151.964));
        elements.add(element = new Element ("Gadolinium","Gd",64,157.25));
        elements.add(element = new Element ("Terbium","Tb",65,158.9253));
        elements.add(element = new Element ("Dysprosium","Dy",66,162.5));
        elements.add(element = new Element ("Holmium","Ho",67,164.9303));
        elements.add(element = new Element ("Erbium","Er",68,167.259));
        elements.add(element = new Element ("Thulium","Tm",69,168.9342));
        elements.add(element = new Element ("Ytterbium","Yb",70,173.04));
        elements.add(element = new Element ("Lutetium","Lu",71,174.967));
        elements.add(element = new Element ("Hafnium","Hf",72,178.49));
        elements.add(element = new Element ("Tantalum","Ta",73,180.9479));
        elements.add(element = new Element ("Tungsten","W", 74,183.84));
        elements.add(element = new Element ("Rhenium","Re",75,186.207));
        elements.add(element = new Element ("Osmium","Os",76,190.23));
        elements.add(element = new Element ("Iridium","Ir",77,192.217));
        elements.add(element = new Element ("Platinum","Pt",78,195.078));
        elements.add(element = new Element ("Gold","Au",79,196.9665));
        elements.add(element = new Element ("Mercury","Hg",80,200.59));
        elements.add(element = new Element ("Thallium","Tl",81,204.3833));
        elements.add(element = new Element ("Lead","Pb",82,207.2));
        elements.add(element = new Element ("Bismuth","Bi",83,208.9804));
        elements.add(element = new Element ("Polonium","Po",84,209));
        elements.add(element = new Element ("Astatine","At",85,210));
        elements.add(element = new Element ("Radon","Rn",86,222));
        elements.add(element = new Element ("Francium","Fr",87,223));
        elements.add(element = new Element ("Radium","Ra",88,226));
        elements.add(element = new Element ("Actinium","Ac",89,227));
        elements.add(element = new Element ("Thorium","Th",90,232.0381));
        elements.add(element = new Element ("Protactinium","Pa",91,231.0359));
        elements.add(element = new Element ("Uranium","U", 92,238.0289));
        elements.add(element = new Element ("Neptunium","Np",93,237));
        elements.add(element = new Element ("Plutonium","Pu",94,244));
        elements.add(element = new Element ("Americium","Am",95,243));
        elements.add(element = new Element ("Curium","Cm",96,247));
        elements.add(element = new Element ("Berkelium","Bk",97,247));
        elements.add(element = new Element ("Californium","Cf",98,251));
        elements.add(element = new Element ("Einsteinium","Es",99,252));
        elements.add(element = new Element ("Fermium","Fm",100,257));
        elements.add(element = new Element ("Mendelevium","Md",101,258));
        elements.add(element = new Element ("Nobelium","No",102,259));
        elements.add(element = new Element ("Lawrencium","Lr",103,262));
        elements.add(element = new Element ("Rutherfordium","Rf",104,261));
        elements.add(element = new Element ("Dubnium","Db",105,262));
        elements.add(element = new Element ("Seaborgium","Sg",106,266));
        elements.add(element = new Element ("Bohrium","Bh",107,264));
        elements.add(element = new Element ("Hassium","Hs",108,277));
        elements.add(element = new Element ("Meitnerium","Mt",109,268));
        elements.add(element = new Element ("Ununnilium","Uun",110,269));
        elements.add(element = new Element ("Unununium","Uuu",111,272));
        elements.add(element = new Element ("Ununbium","Uub",112,277));
    }
    
    public ArrayList<Element> getElements(){
        return elements;       
    }
    
    public Element getElementNum(int num){
        for (Element temp : elements) {
            if (temp.getNumber() == num)return temp;
        }
       return null;
    }
    
    public Element getElementName(String name){
        for (Element temp : elements) {
            String en =temp.getName();
            en = en.toUpperCase();
            if (en.equals(name))return temp;
        }
       return null;
    }
    
     public Element getElementSymbol(String symbol){
        symbol = symbol.toUpperCase();
         for (Element i : elements) {
            String currentElementSymbol = i.getSymbol();
            currentElementSymbol = currentElementSymbol.toUpperCase();
            if (currentElementSymbol.equals(symbol))return i;
        }
       return null;
    }
    
     public Element getElementWeight(double weight){
        for (Element temp : elements) {
            if (Math.round(temp.getWeight()) == weight)return temp;
        }
       return null;
    }
}


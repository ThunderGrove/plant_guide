package initDbContent;

//This Class is only used to create db/plant.db
//and fill in default data in the created database.

import logic.LightTolerance;
import logic.PlantHandler;
import logic.PlantType;
import logic.SoilType;
import persistence.DBLightTolerance;
import persistence.DBPlantType;
import persistence.DBSoilType;

public class main{
    static DBPlantType dbPlantType=new DBPlantType(false);
    static DBSoilType dbSoilType=new DBSoilType(false);
    static DBLightTolerance dbLightTolerance=new DBLightTolerance(false);
    static PlantHandler ph=new PlantHandler();

    public static void main(String[] args){
        persistence.DB.createTables();
        dbSoilType.create(new SoilType(1,"Ler/Silt"));
        dbSoilType.create(new SoilType(2,"Sand"));
        dbSoilType.create(new SoilType(3,"Kalk"));
        dbSoilType.create(new SoilType(4,"Sur"));
        dbPlantType.create(new PlantType(1,"Busk"));
        dbPlantType.create(new PlantType(2,"Stauder"));
        dbPlantType.create(new PlantType(3,"Slyngplanter"));
        dbPlantType.create(new PlantType(4, "Løgplanter"));
        dbLightTolerance.create(new LightTolerance(1,"Sol"));
        dbLightTolerance.create(new LightTolerance(2,"Skygge"));
        dbLightTolerance.create(new LightTolerance(3,"Tolerant"));

        //SoilType 1 Ler/Silt:
        ph.createPlant("Rose",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Rosa hýbrida sp.");
        ph.createPlant("Japankvæde",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Chaenoméles sp.");
        ph.createPlant("Dværgmispel",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Cotoneáster sp.");
        ph.createPlant("Snebær",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Symphoricárpos sp.");

        ph.createPlant("Aukuba",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Aucúba japónica sp.");
        ph.createPlant("Mahonie",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Mahónia aquifólium");
        ph.createPlant("Hvid Kornel",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Córnus alba sp.");
        ph.createPlant("Fjældribs",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Ribes alpinum");

        ph.createPlant("Troldnød",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Hamamélis sp.");
        ph.createPlant("Blodribs",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Ribes sanguineum sp.");
        ph.createPlant("Troldhassel",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Córylus avellána");
        ph.createPlant("Rynkeblad",new PlantType(1,"Busk"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Vibúrnum rhytidophýllum");

        ph.createPlant("Akantus",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Acánthus sp.");
        ph.createPlant("Fløjlsblomst",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Tagétes sp.");
        ph.createPlant("Læbeløs",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Ajuga sp.");
        ph.createPlant("Evighedsblomst",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Anáphalis sp.");
        ph.createPlant("Gyldenris",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(1,"Sol"),"Navn på latin: Solidágo hýbrida sp.");

        ph.createPlant("Salomons segl",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Polygonátum sp.");
        ph.createPlant("Kulsukker",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Sýmphytum sp.");
        ph.createPlant("Ingefær",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Arum sp.");
        ph.createPlant("Bispehue",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Epimédium grandiflórum");
        ph.createPlant("Kermesbær",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(2,"Skygge"),"Navn på latin: Phytolácca americána");

        ph.createPlant("Daglilje",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Sédum sp.");
        ph.createPlant("Primula",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Hepática sp.");
        ph.createPlant("Nyserod",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Helléborus sp.");
        ph.createPlant("Nyserod",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Hepática sp.");
        ph.createPlant("Stenurt",new PlantType(2,"Stauder"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Sédum sp.");

        ph.createPlant("Vedben",new PlantType(3,"Slyngplanter"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Hédera sp.");
        ph.createPlant("Blåregn",new PlantType(3,"Slyngplanter"),new SoilType(1,"Ler/Silt"),new LightTolerance(3,"Tolerant"),"Navn på latin: Wistéria sinénsis");

        //SoilType 2 Sand:
        ph.createPlant("Gyvel",new PlantType(1,"Busk"),new SoilType(2,"Sand"),new LightTolerance(1,"Sol"),"Navn på latin: Cýtisus sp.");

        ph.createPlant("Stauder",new PlantType(2,"Stauder"),new SoilType(2,"Sand"),new LightTolerance(2,"Skygge"),"Navn på latin: Geranium sp.");

        ph.createPlant("Kaprifolie",new PlantType(3,"Slyngplanter"),new SoilType(2,"Sand"),new LightTolerance(3,"Tolerant"),"Navn på latin: Lonicera sp.");


        //SoilType 3 Kalk:
        ph.createPlant("Uægte Jasmin",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Philadelphus sp.");
        ph.createPlant("Syren",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Syringa sp.");
        ph.createPlant("Sommerfuglebusk",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Buddleia sp.");
        ph.createPlant("Paryktræ",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Cótinus var.");
        ph.createPlant("Stenrose",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Daphne cneórum");
        ph.createPlant("Blærebælg",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Colútea arboréscens");
        ph.createPlant("Træpæon",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Paeónia arboréscens");

        ph.createPlant("Singrøn",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Vinca sp.");
        ph.createPlant("Vrietorn",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Rhamus sp.");

        ph.createPlant("Spiræa",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Spiraea sp.");
        ph.createPlant("Vårguld",new PlantType(1,"Busk"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Forsythia sp.");

        ph.createPlant("Peru lilje",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Alstromeria sp.");
        ph.createPlant("Pæon",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Paeónia officicinális sp.");
        ph.createPlant("Have-Iris",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Iris germánica sp.");
        ph.createPlant("Ensian",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Gentiána sp.");
        ph.createPlant("Liljer",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Lilium sp.");
        ph.createPlant("Kongelys",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(1,"Sol"),"Navn på latin: Verbáscum sp.");

        ph.createPlant("Hjerteblomst",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Dicentra sp.");
        ph.createPlant("Funkia",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Hosta sp.");
        ph.createPlant("Have primula",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Primula variábilis");
        ph.createPlant("Tidselkugle",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Eschinope ritro");
        ph.createPlant("Liljekonval",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(2,"Skygge"),"Navn på latin: Convallária majális");

        ph.createPlant("Julerose",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Helléborus niger");
        ph.createPlant("Akeleje",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Aquilégia sp.");
        ph.createPlant("Potentil",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Potentilla sp.");
        ph.createPlant("Alunrod",new PlantType(2,"Stauder"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Heúchera brizoides var.");

        ph.createPlant("Clematis",new PlantType(3,"Slyngplanter"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Clematis sp.");
        ph.createPlant("Vinrake",new PlantType(3,"Slyngplanter"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Vitis vinifera sp.");
        ph.createPlant("Vinter-jasmin",new PlantType(3,"Slyngplanter"),new SoilType(3,"Kalk"),new LightTolerance(3,"Tolerant"),"Navn på latin: Jasminum nudiflórum");

        //SoilType 4 Sur:
        ph.createPlant("Hortensia",new PlantType(1,"Busk"),new SoilType(4,"Sur"),new LightTolerance(1,"Sol"),"Navn på latin: Hydrangéa sp.");

        ph.createPlant("Alpeviol",new PlantType(2,"Stauder"),new SoilType(4,"Sur"),new LightTolerance(2,"Skygge"),"Navn på latin: Cyclámen neapolitánum");

        ph.createPlant("Trompetblomst",new PlantType(3,"Slyngplanter"),new SoilType(4,"Sur"),new LightTolerance(3,"Tolerant"),"Navn på latin: Campsis radicana");
    }
}
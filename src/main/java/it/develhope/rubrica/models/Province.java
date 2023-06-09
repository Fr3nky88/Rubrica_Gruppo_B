package it.develhope.rubrica.models;

import java.util.ArrayList;
import java.util.List;

public class Province {
    private static final String AGRIGENTO = "AG";
    private static final String ALESSANDRIA = "AL";
    private static final String ANCONA = "AN";
    private static final String AOSTA = "AO";
    private static final String AREZZO = "AR";
    private static final String ASCOLI_PICENO = "AP";
    private static final String ASTI = "AT";
    private static final String AVELLINO = "AV";
    private static final String BARI = "BA";
    private static final String BARLETTA_ANDRIA_TRANI = "BT";
    private static final String BELLUNO = "BL";
    private static final String BENEVENTO = "BN";
    private static final String BERGAMO = "BG";
    private static final String BIELLA = "BI";
    private static final String BOLOGNA = "BO";
    private static final String BOLZANO = "BZ";
    private static final String BRESCIA = "BS";
    private static final String BRINDISI = "BR";
    private static final String CAGLIARI = "CA";
    private static final String CALTANISSETTA = "CL";
    private static final String CAMPOBASSO = "CB";
    private static final String CASERTA = "CE";
    private static final String CATANIA = "CT";
    private static final String CATANZARO = "CZ";
    private static final String CHIETI = "CH";
    private static final String COMO = "CO";
    private static final String COSENZA = "CS";
    private static final String CREMONA = "CR";
    private static final String CROTONE = "KR";
    private static final String CUNEO = "CN";
    private static final String ENNA = "EN";
    private static final String FERMO = "FM";
    private static final String FERRARA = "FE";
    private static final String FIRENZE = "FI";
    private static final String FOGGIA = "FG";
    private static final String FORLI_CESENA = "FC";
    private static final String FROSINONE = "FR";
    private static final String GENOVA = "GE";
    private static final String GORIZIA = "GO";
    private static final String GROSSETO = "GR";
    private static final String IMPERIA = "IM";
    private static final String ISERNIA = "IS";
    private static final String LA_SPEZIA = "SP";
    private static final String L_AQUILA = "AQ";
    private static final String LATINA = "LT";
    private static final String LECCE = "LE";
    private static final String LECCO = "LC";
    private static final String LIVORNO = "LI";
    private static final String LODI = "LO";
    private static final String LUCCA = "LU";
    private static final String MACERATA = "MC";
    private static final String MANTOVA = "MN";
    private static final String MASSA_CARRARA = "MS";
    private static final String MATERA = "MT";
    private static final String MESSINA = "ME";
    private static final String MILANO = "MI";
    private static final String MODENA = "MO";
    private static final String MONZA_BRIANZA = "MB";
    private static final String NAPOLI = "NA";
    private static final String NOVARA = "NO";
    private static final String NUORO = "NU";
    private static final String OGLIASTRA = "OG";
    private static final String OLBIA_TEMPIO = "OT";
    private static final String OLIO = "OT";
    private static final String ORISTANO = "OR";
    private static final String PALERMO = "PA";
    private static final String PARMA = "PR";
    private static final String PAVIA = "PV";
    private static final String PERUGIA = "PG";
    private static final String PESARO_URBINO = "PU";
    private static final String PESCARA = "PE";
    private static final String PIACENZA = "PC";
    private static final String PISA = "PI";
    private static final String PISTOIA = "PT";
    private static final String PORDENONE = "PN";
    private static final String POTENZA = "PZ";
    private static final String PRATO = "PO";
    private static final String RAGUSA = "RG";
    private static final String RAVENNA = "RA";
    private static final String REGGIO_CALABRIA = "RC";
    private static final String REGGIO_EMILIA = "RE";
    private static final String RIETI = "RI";
    private static final String RIMINI = "RN";
    private static final String ROMA = "RM";
    private static final String ROVIGO = "RO";
    private static final String SALERNO = "SA";
    private static final String SASSARI = "SS";
    private static final String SAVONA = "SV";
    private static final String SIENA = "SI";
    private static final String SIRACUSA = "SR";
    private static final String SONDRIO = "SO";
    private static final String TARANTO = "TA";
    private static final String TERAMO = "TE";
    private static final String TERNI = "TR";
    private static final String TORINO = "TO";
    private static final String TRAPANI = "TP";
    private static final String TRENTO = "TN";
    private static final String TRIESTE = "TS";
    private static final String UDINE = "UD";
    private static final String VARESE = "VA";
    private static final String VENEZIA = "VE";
    private static final String VERBANO_CUSIO_OSSOLA = "VB";
    private static final String VERCELLI = "VC";
    private static final String VERONA = "VR";
    private static final String VIBO_VALENTIA = "VV";
    private static final String VICENZA = "VI";
    private static final String VITERBO = "VT";

    private static List<String> province = new ArrayList<>();

    public Province() {
        adderProvince();
    }

    public static List<String> adderProvince() {
        province.add(ALESSANDRIA);
        province.add(AGRIGENTO);
        province.add(ANCONA);
        province.add(AOSTA);
        province.add(AREZZO);
        province.add(ASCOLI_PICENO);
        province.add(ASTI);
        province.add(AVELLINO);
        province.add(BARI);
        province.add(BARLETTA_ANDRIA_TRANI);
        province.add(BELLUNO);
        province.add(BENEVENTO);
        province.add(BERGAMO);
        province.add(BIELLA);
        province.add(BOLOGNA);
        province.add(BOLZANO);
        province.add(BRESCIA);
        province.add(BRINDISI);
        province.add(CAGLIARI);
        province.add(CALTANISSETTA);
        province.add(CAMPOBASSO);
        province.add(CASERTA);
        province.add(CATANIA);
        province.add(CATANZARO);
        province.add(CHIETI);
        province.add(COMO);
        province.add(COSENZA);
        province.add(CREMONA);
        province.add(CROTONE);
        province.add(CUNEO);
        province.add(ENNA);
        province.add(FERMO);
        province.add(FERRARA);
        province.add(FIRENZE);
        province.add(FOGGIA);
        province.add(FORLI_CESENA);
        province.add(FROSINONE);
        province.add(GENOVA);
        province.add(GORIZIA);
        province.add(GROSSETO);
        province.add(IMPERIA);
        province.add(ISERNIA);
        province.add(LA_SPEZIA);
        province.add(L_AQUILA);
        province.add(LATINA);
        province.add(LECCE);
        province.add(LECCO);
        province.add(LIVORNO);
        province.add(LODI);
        province.add(LUCCA);
        province.add(MACERATA);
        province.add(MANTOVA);
        province.add(MASSA_CARRARA);
        province.add(MATERA);
        province.add(MESSINA);
        province.add(MILANO);
        province.add(MODENA);
        province.add(MONZA_BRIANZA);
        province.add(NAPOLI);
        province.add(NOVARA);
        province.add(NUORO);
        province.add(OGLIASTRA);
        province.add(OLBIA_TEMPIO);
        province.add(OLIO);
        province.add(ORISTANO);
        province.add(PALERMO);
        province.add(PARMA);
        province.add(PAVIA);
        province.add(PERUGIA);
        province.add(PESARO_URBINO);
        province.add(PESCARA);
        province.add(PIACENZA);
        province.add(PISA);
        province.add(PISTOIA);
        province.add(PORDENONE);
        province.add(POTENZA);
        province.add(PRATO);
        province.add(RAGUSA);
        province.add(RAVENNA);
        province.add(REGGIO_CALABRIA);
        province.add(REGGIO_EMILIA);
        province.add(RIETI);
        province.add(RIMINI);
        province.add(ROMA);
        province.add(ROVIGO);
        province.add(SALERNO);
        province.add(SASSARI);
        province.add(SAVONA);
        province.add(SIENA);
        province.add(SIRACUSA);
        province.add(SONDRIO);
        province.add(TARANTO);
        province.add(TERAMO);
        province.add(TERNI);
        province.add(TORINO);
        province.add(TRAPANI);
        province.add(TRENTO);
        province.add(TRIESTE);
        province.add(UDINE);
        province.add(VARESE);
        province.add(VENEZIA);
        province.add(VERBANO_CUSIO_OSSOLA);
        province.add(VERCELLI);
        province.add(VERONA);
        province.add(VIBO_VALENTIA);
        province.add(VICENZA);
        province.add(VITERBO);

        return province;
    }
    public static List<String> getProvince() {
        return province;
    }
}

public class Attribut {
    public String name;
    public String typ;
    public boolean privat;
    public boolean setter;
    public boolean getter;
    public boolean konstruktor;
    private String attributVorlage = "%isPrivate %type %name;";
    private String getterVorlage = "public %type get%Name() {\n" +
    "  return %name;\n" +
    "}";
    private String setterVorlage = "public void get%Name(%type p%Name) {\n" +
    "  %name = p%Name;\n" +
    "}";

    public Attribut(String pName, String pTyp, boolean pPrivat, boolean pSetter, boolean pGetter, boolean pKonstruktor) {
      name = pName;
      typ = pTyp;
      privat = pPrivat;
      setter = pSetter;
      getter = pGetter;
      konstruktor = pKonstruktor;
    }

    public String asString() {
      return attributVorlage.replace("%name", name).replace("%type", typ).replace("%isPrivate", Utils.boolToPString(privat));
    }
    public String getGetterString() {
      return getterVorlage.replace("%type", typ).replace("%Name", Utils.capitalize(name));
    }

  }

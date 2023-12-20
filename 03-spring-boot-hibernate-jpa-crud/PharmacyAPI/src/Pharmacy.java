public class Pharmacy {
    String pharmacyName;
    String pharmacyDistrict ;
    String pharmacyAddress;
    String pharmacyPhone;
    String pharmacyLocation;

    public Pharmacy(String pharmacyName, String pharmacyDistrict, String pharmacyAddress, String pharmacyPhone, String pharmacyLocation) {
        this.pharmacyName = pharmacyName;
        this.pharmacyDistrict = pharmacyDistrict;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyPhone = pharmacyPhone;
        this.pharmacyLocation = pharmacyLocation;
    }

    public String info(){
        String information="Eczane adı: "+this.pharmacyName+"\n Eczane Semti: "+this.pharmacyDistrict+"\n Eczane Adresi: "+this.pharmacyAddress
                +"\n Eczane Tel:"+this.pharmacyPhone+"\n Eczane Koordinat: "+this.pharmacyLocation;
        return information;
    }


}

package Model;


public class CropField extends Field {
    static int idStatic = 0;
    private boolean irrigated;
    private Crop cropType;

    public CropField() {

    }

    public CropField(int id, String name, int size, int type, boolean irrigated, Crop cropType) {
        super(id, name, size, type);
        this.irrigated = irrigated;
        this.cropType = cropType;
    }
    // pentru autoincrementarea id-ului
    public CropField(String name, int size, int type, boolean irrigated, Crop cropType) {
        super(idStatic++, name, size, type);
        idStatic = idStatic + 1;
        this.irrigated = irrigated;
        this.cropType = cropType;
    }


    public boolean isIrrigated() {
        return irrigated;
    }

    public void setIrrigated(boolean irrigated) {
        this.irrigated = irrigated;
    }

    public Crop getCropType() {
        return cropType;
    }

    public void setCropType(Crop cropType) {
        this.cropType = cropType;
    }

    @Override
    public String toString() {
        return "CropField{" +
                "id=" + id +
                ", irrigated=" + irrigated +
                ", cropType=" + cropType +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}

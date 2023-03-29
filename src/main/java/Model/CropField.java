package Model;


enum Crop{
    WHEAT,
    BARLEY,
    OATS,
    RYE,
    CORN,
    BEANS,
    BEETS
}


public class CropField extends Field{
    private boolean irrigated;
    private Crop cropType;

    public CropField() {
    }

    public CropField(String name, int size, int type, boolean irrigated, Crop cropType) {
        super(name, size, type);
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
                "irrigated=" + irrigated +
                ", cropType=" + cropType +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}

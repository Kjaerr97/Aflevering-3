package DTO;

public class LabtechDTO implements ILabtechDTO{
    private String labtechName;

    @Override
    public String getLabtechName() {
        return labtechName;
    }

    @Override
    public void setLabtechName(String labtechName) {
        this.labtechName = labtechName;
    }
}

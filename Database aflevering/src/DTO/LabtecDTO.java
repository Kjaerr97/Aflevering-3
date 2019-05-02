package DTO;

public class LabtecDTO implements ILabtecDTO {
    private String labtecName;

    @Override
    public String getLabtecName() {
        return labtecName;
    }

    @Override
    public void setLabtecName(String labtecName) {
        this.labtecName = labtecName;
    }
}

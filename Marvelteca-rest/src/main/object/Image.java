import lombok.Data;
@Data
public class Image {
    private String path;
    private String extension;
    public Image(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
}

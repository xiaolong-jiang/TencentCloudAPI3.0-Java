import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencentcloudapi.facefusion.v20181201.models.FaceRect;

public class LogoParam{

    /**
     * logo图片位于视频中的坐标
     */
    @SerializedName("LogoRect")
    @Expose
    private FaceRect LogoRect;

    /**
     * logo图片Url地址
     */
    @SerializedName("LogoUrl")
    @Expose
    private String LogoUrl;

    /**
     * logo图片base64
     */
    @SerializedName("LogoImage")
    @Expose
    private String LogoImage;

    /**
     * Get logo图片位于视频中的坐标
     * @return LogoRect logo图片位于视频中的坐标
     */
    public FaceRect getLogoRect() {
        return this.LogoRect;
    }

    /**
     * Set logo图片位于视频中的坐标
     * @param LogoRect logo图片位于视频中的坐标
     */
    public void setLogoRect(FaceRect LogoRect) {
        this.LogoRect = LogoRect;
    }

    /**
     * Get logo图片Url地址
     * @return LogoUrl logo图片Url地址
     */
    public String getLogoUrl() {
        return this.LogoUrl;
    }

    /**
     * Set logo图片Url地址
     * @param LogoUrl logo图片Url地址
     */
    public void setLogoUrl(String LogoUrl) {
        this.LogoUrl = LogoUrl;
    }

    /**
     * Get logo图片base64
     * @return LogoImage logo图片base64
     */
    public String getLogoImage() {
        return this.LogoImage;
    }

    /**
     * Set logo图片base64
     * @param LogoImage logo图片base64
     */
    public void setLogoImage(String LogoImage) {
        this.LogoImage = LogoImage;
    }

    public LogoParam() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     *       and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public LogoParam(LogoParam source) {
        if (source.LogoRect != null) {
            this.LogoRect = new FaceRect(source.LogoRect);
        }
        if (source.LogoUrl != null) {
            this.LogoUrl = new String(source.LogoUrl);
        }
        if (source.LogoImage != null) {
            this.LogoImage = new String(source.LogoImage);
        }
    }
}

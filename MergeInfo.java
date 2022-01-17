import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencentcloudapi.facefusion.v20181201.models.FaceRect;

public class MergeInfo {

    /**
     * 输入图片base64
     */
    @SerializedName("Image")
    @Expose
    private String Image;

    /**
     * 输入图片url
     */
    @SerializedName("Url")
    @Expose
    private String Url;

    /**
     * 上传的图片人脸位置信息（人脸框）
     */
    @SerializedName("InputImageFaceRect")
    @Expose
    private FaceRect InputImageFaceRect;

    /**
     * 控制台上传的素材人脸ID
     */
    @SerializedName("TemplateFaceID")
    @Expose
    private String TemplateFaceID;

    /**
     * Logo图片url
     */
    @SerializedName("LogoUrl")
    @Expose
    public String LogoUrl;

    /**
     * Logo图片参数位置信息（Logo框）
     */
    @SerializedName("InputImageLogoRect")
    @Expose
    public Object InputImageLogoRect;

    /**
     * Get 输入图片base64
     * @return Image 输入图片base64
     */
    public String getImage() {
        return this.Image;
    }

    /**
     * Set 输入图片base64
     * @param Image 输入图片base64
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    /**
     * Get 输入图片url
     * @return Url 输入图片url
     */
    public String getUrl() {
        return this.Url;
    }

    /**
     * Set 输入图片url
     * @param Url 输入图片url
     */
    public void setUrl(String Url) {
        this.Url = Url;
    }

    /**
     * Get 上传的图片人脸位置信息（人脸框）
     * @return InputImageFaceRect 上传的图片人脸位置信息（人脸框）
     */
    public FaceRect getInputImageFaceRect() {
        return this.InputImageFaceRect;
    }

    /**
     * Set 上传的图片人脸位置信息（人脸框）
     * @param InputImageFaceRect 上传的图片人脸位置信息（人脸框）
     */
    public void setInputImageFaceRect(FaceRect InputImageFaceRect) {
        this.InputImageFaceRect = InputImageFaceRect;
    }

    /**
     * Get 控制台上传的素材人脸ID
     * @return TemplateFaceID 控制台上传的素材人脸ID
     */
    public String getTemplateFaceID() {
        return this.TemplateFaceID;
    }

    /**
     * Set 控制台上传的素材人脸ID
     * @param TemplateFaceID 控制台上传的素材人脸ID
     */
    public void setTemplateFaceID(String TemplateFaceID) {
        this.TemplateFaceID = TemplateFaceID;
    }

    /**
     * Get Logo图片url
     * @return LogoUrl Logo图片url
     */
    public String getLogoUrl() {
        return this.LogoUrl;
    }

    /**
     * Set Logo图片url
     * @param LogoUrl Logo图片url
     */
    public void setLogoUrl(String LogoUrl) {
        this.LogoUrl = LogoUrl;
    }

    /**
     * Get Logo图片参数位置信息
     * @return InputImageLogoRect Logo图片参数位置信息
     */
    public Object getInputImageLogoRect() {
        return this.InputImageLogoRect;
    }

    /**
     * Set Logo图片参数位置信息
     * @param InputImageLogoRect Logo图片参数位置信息
     */
    public void setInputImageLogoRect(Object InputImageLogoRect) {
        this.InputImageLogoRect = InputImageLogoRect;
    }

    public MergeInfo() {
    }

    /**
     * NOTE: Any ambiguous key set via .set("AnyKey", "value") will be a shallow copy,
     *       and any explicit key, i.e Foo, set via .setFoo("value") will be a deep copy.
     */
    public MergeInfo(MergeInfo source) {
        if (source.Image != null) {
            this.Image = new String(source.Image);
        }
        if (source.Url != null) {
            this.Url = new String(source.Url);
        }
        if (source.InputImageFaceRect != null) {
            this.InputImageFaceRect = new FaceRect(source.InputImageFaceRect);
        }
        if (source.TemplateFaceID != null) {
            this.TemplateFaceID = new String(source.TemplateFaceID);
        }
    }
}



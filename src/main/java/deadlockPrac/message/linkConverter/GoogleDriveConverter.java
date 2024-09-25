package deadlockPrac.message.linkConverter;

public class GoogleDriveConverter {
    public static String convertToDirectLink(String originalUrl) {
        if (originalUrl.contains("/file/d/")) {
            String fileId = originalUrl.split("/file/d/")[1].split("/")[0];
            return "https://drive.google.com/uc?export=view&id=" + fileId;
        } else {
            return null;
        }
    }

}

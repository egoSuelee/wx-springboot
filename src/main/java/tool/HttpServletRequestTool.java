package tool;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestTool {

    public static String getURLPath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"+ request.getServerName() + (request.getServerPort() == 80 ? "" : ":"+request.getServerPort()) + path + "/";
        return basePath;
    }


}

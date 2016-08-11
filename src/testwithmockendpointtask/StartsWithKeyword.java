package testwithmockendpointtask;

public class StartsWithKeyword implements Endpoint {
    @Override
    public boolean matches(String url) {
        String keyword = "www";
        if(url.startsWith(keyword)){
            return true;
        }
        return false;
    }
}

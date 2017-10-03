import com.scy.mall.common.ServerResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Shichengyao on 2017/8/1.
 */
public class JsonTest {
    @Test
    public void demo1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ServerResponse response = new ServerResponse(0, "message", "123");
        String s = objectMapper.writeValueAsString(response);
        System.out.println(s);
    }


}

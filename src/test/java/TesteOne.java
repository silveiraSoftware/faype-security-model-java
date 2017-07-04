import com.faype.security.domain.User;
import org.junit.Test;

import java.net.*;
import java.util.UUID;

/**
 * Created by wmfsystem on 7/3/17.
 */
public class TesteOne {

    @Test
    public void teste() {
        NetworkInterface netInf = null;
        try {
            netInf = NetworkInterface.getNetworkInterfaces().nextElement();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] mac = new byte[0]
                ;
        try {
            mac = netInf.getHardwareAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }

        UUID uuid = UUID.nameUUIDFromBytes("amdfdn".getBytes());
        String token = sb.toString().concat(uuid.toString());
        System.out.println(token);
    }
}

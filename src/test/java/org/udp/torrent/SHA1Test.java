package org.udp.torrent;

import org.junit.Test;
import org.udp.torrent.util.SHA1;

public class SHA1Test {



	@Test
    public void sha1Test() {
        String data = "1";
        System.out.println(data);

        String digest = new SHA1().getDigestOfString(data.getBytes());
        System.out.println(digest);
    }
    
}

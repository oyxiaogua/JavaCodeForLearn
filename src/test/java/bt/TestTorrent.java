package bt;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.turn.ttorrent.common.Torrent;

public class TestTorrent {
	
	public String getTorrentLink(File btFile) throws Exception {
		Torrent torrent = new Torrent(FileUtils.readFileToByteArray(btFile), false);
		return "magnet:?xt=urn:btih:" + torrent.getHexInfoHash();
	}
}

package pp.bodis.crispydoom;

import org.libsdl.app.SDLActivity;

import android.os.Bundle;
import android.os.Environment;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission;

public class MainActivity extends SDLActivity
{
	private static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

	@Override
	protected String[] getLibraries() {
		return new String[] {
			"hidapi",
			"SDL2",
			"SDL2_mixer",
			"SDL2_net",
			"crispy-doom"
		};
	}
	
	@Override
	protected String[] getArguments() {
        return new String[] {
			"-iwad",
			Environment.getExternalStorageDirectory().toString() + "/CrispyDoom/DOOM2.WAD"
		};
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (ContextCompat.checkSelfPermission(this, permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        }
	}
}
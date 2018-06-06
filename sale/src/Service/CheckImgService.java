package Service;

import java.awt.Color;

public interface CheckImgService {

	void init();

	void check();
	
	Color getRandColor(int fc, int bc);
}

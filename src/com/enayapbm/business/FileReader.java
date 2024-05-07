package com.enayapbm.business;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public interface FileReader<T> {
	List<T> readFile(InputStream in) throws IOException, ParseException;
}

package org.mule;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class JarFinder {

	private static final class JarFilter implements FilenameFilter {
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".jar") && !name.contains("clover")  && !name.contains("mule");
		}
	}

	public static Collection<String> getJars(String folder){
		
		List<File> asList = Arrays.asList(new File(folder).listFiles(new JarFilter()));
		Function<File, String> getName = new Function<File, String>() {

			@Override
			public String apply(File arg0) {
				// TODO Auto-generated method stub
				return arg0.getName() ;
			}
		};
		return Collections2.transform(asList, getName);	
	}
	public static boolean exists(String name){
		File filesWithLic = new File("/Users/matiaspentreath/AnypointStudio/workspace-dfl-ui/test-dw/src/test/resources/output/lic",name + ".json"); 
		File filesWithNoLic = new File("/Users/matiaspentreath/AnypointStudio/workspace-dfl-ui/test-dw/src/test/resources/output/no/lic",name + ".json");
		return (filesWithLic.exists() || filesWithNoLic.exists()); 
	}
	
}
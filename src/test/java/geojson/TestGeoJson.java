package geojson;

import java.util.HashMap;
import java.util.Map;

import org.geojson.Crs;
import org.geojson.Feature;
import org.geojson.GeoJsonObject;
import org.geojson.GeometryCollection;
import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.geojson.jackson.CrsType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestGeoJson {
	private static final Logger log = LoggerFactory.getLogger(TestGeoJson.class);
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testWritePointAsStr() throws Exception {
		Point geoPoint = new Point();
		Crs crs = new Crs();
		Map<String, Object> propMap = new HashMap<String, Object>();
		propMap.put("testKey", "testValue");
		crs.setProperties(propMap);
		crs.setType(CrsType.link);
		geoPoint.setCrs(crs);
		geoPoint.setCoordinates(new LngLatAlt(125.6, 10.1));
		log.info(mapper.writeValueAsString(geoPoint));
	}

	@Test
	public void testWriteGeometryCollectionAsStr() throws Exception {
		GeometryCollection gc = new GeometryCollection();
		gc.add(new Point(100, 0));
		gc.add(new LineString(new LngLatAlt(101, 0), new LngLatAlt(102, 1)));
		String jsonStr = mapper.writeValueAsString(gc);
		log.info("jsonStr={}", jsonStr);
		GeometryCollection geometryCollection = mapper.readValue(jsonStr, GeometryCollection.class);
		log.info("geometryCollection={}", geometryCollection);
	}

	@Test
	public void testReadGeoJsonStr() throws Exception {
		String geoJsonStr = "{\"type\": \"Feature\", \"geometry\": { \"type\": \"Point\", \"coordinates\": [125.6, 10.1] }, \"properties\": { \"name\": \"Dinagat Islands\" }}";
		GeoJsonObject geoJsonObj = mapper.readValue(geoJsonStr, GeoJsonObject.class);
		if (geoJsonObj instanceof Feature) {
			Feature feature = (Feature) geoJsonObj;
			log.info(feature.toString());
		}
	}
}

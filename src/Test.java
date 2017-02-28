
	import org.codehaus.jackson.map.ObjectMapper;

	import com.app.model.Part;

	public class Test {

		public static void main1(String[] args) {
			//obj=>JSON
			Part p=new Part();
			p.setPartId(55);
			p.setPartName("AA");
			p.setCost(556.36);
			
			try {
				//obj=>JSON
				ObjectMapper om=new ObjectMapper();
				String json=om.writeValueAsString(p);
				System.out.println(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public static void main(String[] args) {
			String json="{\"partId\":43,\"partName\":\"AA\",\"cost\":89.36}";
			try {
				ObjectMapper om=new ObjectMapper();
				//JSON->obj
				Part p=om.readValue(json, Part.class);
				System.out.println(p.getPartId());
				System.out.println(p.getPartName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		
	}

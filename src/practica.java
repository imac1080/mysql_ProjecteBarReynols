import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class practica {
	public static void main(String[] args) {
		Connection conexion;
		try {
			Scanner teclat = new Scanner(System.in);
			/*
			 * String usuario = "root"; String password = ""; String urlBBDD =
			 * "jdbc:mysql://localhost:3306/bd_videoclub?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			 */
			String usuario = "zuk5X2TjSn";
			String password = "ioXxebaOEY";
			String urlBBDD = "jdbc:mysql://remotemysql.com:3306/zuk5X2TjSn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			conexion = DriverManager.getConnection(urlBBDD, usuario, password);
			Statement st = conexion.createStatement();
			//int o = menuPrincipal();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT * from SOCIO;");
            String respuesta="";
            while (rs.next()) {
                respuesta=/*respuesta+" | "+*/("cod_soci=" + rs.getObject("COD_SOC") + ", nombre=" + rs.getObject("NOMBRE")
                        + ", apellidos=" + rs.getObject("APELLIDOS") + ", CUOTA=" + rs.getObject("CUOTA"));
            }
            System.out.println(respuesta);
			/*
			switch (o) {
			case 1:
				/*System.out.println("Digues el codi soci");
				String cod_soci = teclat.nextLine();
				System.out.println("Digues el codi nom del soci");
				String nom_soci = teclat.nextLine();
				System.out.println("Digues el codi cognom del soci");
				String cognom_soci = teclat.nextLine();
				System.out.println("Digues la direccio del soci");
				String dirr_soci = teclat.nextLine();
				System.out.println("Digues el telefon del soci");
				String tel_soci = teclat.nextLine();
				System.out.println("Digues la poblacio del soci");
				String poblacio_soci = teclat.nextLine();
				System.out.println("Digues el cp del soci");
				String cp_soci = teclat.nextLine();
				System.out.println("Digues la provincia del soci");
				String provincia_soci = teclat.nextLine();
				System.out.println("Digues el pais del soci");
				String pais_soci = teclat.nextLine();
				System.out.println("Digues la edat del soci");
				String edat_soci = teclat.nextLine();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String data_soci = dtf.format(now);
				System.out.println("Digues la cuota del soci");
				String cuota_soci = teclat.nextLine();
				st.executeUpdate(
						"INSERT INTO SOCIO (COD_SOC, NOMBRE, APELLIDOS, DIRECCION, TELEFONO, POBLACION, CP, PROVINCIA, PAIS, EDAD, FECHAALTA, CUOTA) VALUES "
								+ "(" + cod_soci + ", '" + nom_soci + "', '" + cognom_soci + "', '" + dirr_soci + "', '"
								+ tel_soci + "', '" + poblacio_soci + "', '" + cp_soci + "', '" + provincia_soci
								+ "', '" + pais_soci + "', " + edat_soci + ", '" + data_soci + "', " + cuota_soci
								+ ");");
				
				 rs = st.executeQuery("SELECT * from SOCIO;");
		            String respuesta="";
		            System.out.println(respuesta);
				break;
			/*case 2:
				System.out.println("Digues el codi soci");
				cod_soci = teclat.nextLine();
				rs = st.executeQuery("SELECT * FROM SOCIO WHERE COD_SOC =" + cod_soci + ";");
				while (rs.next()) {
					System.out.println("cod_soci=" + rs.getObject("COD_SOC") + ", nombre=" + rs.getObject("NOMBRE")
							+ ", apellidos=" + rs.getObject("APELLIDOS") + ", CUOTA=" + rs.getObject("CUOTA"));
				}
				System.out.println("Vols modificar la cuota? SI/NO");
				String sino = teclat.nextLine();
				if (sino.equalsIgnoreCase("SI")) {
					System.out.println("Digues la nova cuota");
					String novaCuota = teclat.nextLine();
					st.executeUpdate("UPDATE SOCIO SET CUOTA='" + novaCuota + "' WHERE COD_SOC=" + cod_soci);
				}
				rs.close();
				break;
			case 3:
				System.out.println("Digues el codi soci que vulguis eliminar");
				cod_soci = teclat.nextLine();
				rs = st.executeQuery("SELECT * FROM SOCIO WHERE COD_SOC =" + cod_soci + ";");
				while (rs.next()) {
					System.out.println("cod_soci=" + rs.getObject("COD_SOC") + ", nombre=" + rs.getObject("NOMBRE")
							+ ", apellidos=" + rs.getObject("APELLIDOS") + ", CUOTA=" + rs.getObject("CUOTA"));
				}
				System.out.println("Vols eliminar el soci? SI/NO");
				sino = teclat.nextLine();
				if (sino.equalsIgnoreCase("SI")) {
					st.executeUpdate("DELETE FROM SOCIO WHERE COD_SOC=" + cod_soci);
				}
				rs.close();
				st.close();
				break;

			}*/
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int menuPrincipal() {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0;
		System.out.println("");
		System.out.println("==============================================");
		System.out.println("1. DOANR D'ALTA SOCI");
		System.out.println("2. MODIFICAR CUOTA SOCI");
		System.out.println("3. ELIMINAR SOCI");
		System.out.println("4. SORTIR");
		System.out.print("Escull una opcio:");
		while (!teclat.hasNextInt()) {
			System.out.println("");
			System.out.println("==============================================");
			System.out.println("1. DOANR D'ALTA SOCI");
			System.out.println("2. MODIFICAR CUOTA SOCI");
			System.out.println("3. ELIMINAR SOCI");
			System.out.println("4. SORTIR");
			System.out.print("Escull una opcio:");
			teclat.nextLine();
		}
		opcio = teclat.nextInt();
		return opcio;
	}
}

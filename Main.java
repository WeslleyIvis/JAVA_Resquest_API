
public class Main {
    public static void main(String[] args) {
        ResquetAPI requestAPI = new ResquetAPI();

        requestAPI.request("https://pokeapi.co/api/v2/pokemon/ditto", "GET");
    }
}
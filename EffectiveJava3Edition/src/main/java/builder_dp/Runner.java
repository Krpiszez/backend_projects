package builder_dp;

public class Runner {

    public static void main(String[] args) {

        Menemen sarimsakli = new Menemen.Builder("koy", "inek").sarimsakTayfa("bol").soganTayfa("az").build();
        Menemen etli = new Menemen.Builder("gezen", "manda").etTayfa("bol", "yok", "az", "az").build();

        System.out.println(sarimsakli.getBaharat());
        System.out.println(sarimsakli.getSarimsak());
        System.out.println(etli.getBiber());
        System.out.println(etli.getSalam());
        System.out.println(etli.getKavurma());
        System.out.println(etli.getPastirma());
    }
}

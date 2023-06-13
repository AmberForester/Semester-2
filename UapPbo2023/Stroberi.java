package UapPbo2023;

public class Stroberi extends Tanaman implements Perawatan {

    public Stroberi(){
        setMasaHidup(60);
        setBerbuah(150);
        setPerkembangan(0.35);
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.025);
    }

    @Override
    public void berkembang() {
        if (this.getLamaHidup()<=this.getMasaHidup()) {
            if (this.getProsesBerbuah() >= this.getBerbuah()) {
                 int buah = this.getBuah();
                buah++;
                this.setBuah(buah);
                this.setProsesBerbuah(this.getProsesBerbuah() - this.getBerbuah());
            } else {
                if (getProsesBerbuah()==0) this.setProsesBerbuah(this.getBerbuah() * this.getPerkembangan());
                this.setProsesBerbuah(this.getProsesBerbuah() + this.getBerbuah() * this.getPerkembangan());
            }
        }
        this.setLamaHidup(this.getLamaHidup()+1);
    }
}

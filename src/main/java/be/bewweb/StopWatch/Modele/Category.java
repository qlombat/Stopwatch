package be.bewweb.StopWatch.Modele;

/**
 * Created by Quentin on 17-02-16.
 */
public class Category {
    int adult;
    int child;
    int young;
    int senior;
    int veteranA;
    boolean master;

    public Category() {
        this.adult = 16;
        this.child = 12;
        this.young = 21;
        this.senior = 40;
        this.veteranA = 50;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getYoung() {
        return young;
    }

    public void setYoung(int young) {
        this.young = young;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getVeteranA() {
        return veteranA;
    }

    public void setVeteranA(int veteranA) {
        this.veteranA = veteranA;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public String getCategoryOfTeam(Team team){
        if(isMaster()){
            //Un classement général avec mention des catégories (moyenne d?âge des deux équipiers).
            float avrAge = ((float) team.getRunner1().getAge() + team.getRunner2().getAge()) / ((float) 2);
            //Jeunes : moins de 21 ans
            if (avrAge < this.young && team.getRunner2().isMan() && team.getRunner1().isMan()) {
                return "Jeune";
            }
            //Seniors : plus ou égal à 21 ans et moins de 40 ans
            if (avrAge >= this.young && avrAge < this.senior && team.getRunner2().isMan() && team.getRunner1().isMan()) {
                return "Senior";
            }
            //Vétérans A : plus ou égal à 40 ans et moins de 50 ans
            if (avrAge >= this.senior && avrAge < this.veteranA && team.getRunner2().isMan() && team.getRunner1().isMan()) {
                return "Vétéran A";
            }
            //Vétérans B : plus de 50 ans
            if (avrAge >= this.veteranA && team.getRunner2().isMan() && team.getRunner1().isMan()) {
                return "Vétéran B";
            }

            //Dame
            if (!team.getRunner1().isMan() && !team.getRunner2().isMan()) {
                return "Dame";
            }

            //Mixte
            if (!team.getRunner1().isMan() && team.getRunner2().isMan()) {
                return "Mixte";
            }
            if (team.getRunner1().isMan() && !team.getRunner2().isMan()) {
                return "Mixte";
            }

        }else{
            //Familles A : A moins de 12 ans - B plus de 16 ans.
            if (team.getRunner1().getAge() < this.child && team.getRunner2().getAge() > this.adult) {
                return "Famille A";
            }
            if (team.getRunner2().getAge() < this.child && team.getRunner1().getAge() > this.adult) {
                return "Famille A";
            }

            //Familles B : A entre 12 et 16 ans - B plus de 16 ans.
            if (team.getRunner1().getAge() >= this.child && team.getRunner1().getAge() <= this.adult && team.getRunner2().getAge() > this.adult) {
                return "Famille B";
            }
            if (team.getRunner2().getAge() >= this.child && team.getRunner2().getAge() <= this.adult && team.getRunner1().getAge() > this.adult) {
                return "Famille B";
            }

            //Jeunes A : A et B moins de 12 ans.
            if (team.getRunner1().getAge() < this.child && team.getRunner2().getAge() < this.child) {
                return "Jeune A";
            }

            //Jeunes B : A moins de 12 - B entre 12 et 16 ans.
            if (team.getRunner1().getAge() >= this.child && team.getRunner1().getAge() <= this.adult && team.getRunner2().getAge() < this.child) {
                return "Jeune B";
            }
            if (team.getRunner2().getAge() >= this.child && team.getRunner2().getAge() <= this.adult && team.getRunner1().getAge() < this.child) {
                return "Jeune B";
            }

            //Jeunes C : A et B entre 12 et 16 ans.
            if (team.getRunner1().getAge() >= this.child && team.getRunner1().getAge() <= this.adult && team.getRunner2().getAge() >= this.child && team.getRunner2().getAge() <= this.adult) {
                return "Jeune C";
            }

            //Adultes : les équipes dont les 2 ont plus de 16 ans seront reprises dans un classement à part et seront récompensées.
            if (team.getRunner1().getAge() > this.adult && team.getRunner2().getAge() > this.adult) {
                return "Adulte";
            }
        }
        return "N/A";
    }
}

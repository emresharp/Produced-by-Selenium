import com.thoughtworks.gauge.Step;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Steps extends BaseTest{

    @Step("Wait <seconds> seconds")
    public void waitSeconds(int seconds) throws InterruptedException {;
        Thread.sleep(1000L * seconds);
    }

    @Step("Click to <xpath>")
    public void click(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    @Step("Sendkeys <xpath> to <string>")
    public void senkeystoField(String xpath ,String string) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(string);
    }

    @Step("Sendkeys to <xpath> BPM <seconds>")
    public void sendKeysBPM(String xpath, int seconds) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(String.valueOf(seconds));
        System.out.println("BPM = " + seconds );
    }

    @Step("Create Random BPM to <xpath> and Click to <xpath1>")
    public void createRandomBPM(String xpath,String xpath1) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        Random rnd = new Random();
        int bpm = rnd.nextInt(180) + 60;
        element.sendKeys(String.valueOf(bpm));
        System.out.println("BPM = " + bpm);
        WebElement element1 = driver.findElement(By.xpath(xpath1));
        element1.click();
    }

    @Step("Copy The Link <xpath>")
    public void copyTheLink(String xpath) {
        WebElement element =driver.findElement(By.xpath(xpath));
        String link = element.getAttribute("content");
        System.out.println("Beat is Ready ! -> " + link);
    }

    @Step("Instrument Control")
    public void instrumentControl(){

        int counter = driver.findElements(By.className("sample-name")).size();
        System.out.println("Number of Sample Instruments = "+ counter);

        for (int i = 1; i <= counter; i++) {
            Assert.assertTrue(driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/app-sample-select[1]/div[1]/div[2]/div[1]/div[" + i + "]")).isDisplayed());
            System.out.println("Sample of Instrument is Displayed " + i + " -> //body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/app-sample-select[1]/div[1]/div[2]/div[1]/div[" + i + "]");
        }
    }

    @Step("Instrument Selecting")
    public  void instrumentSelecting(){

        int counter = driver.findElements(By.className("sample-name")).size();
        System.out.println("Number of Samples = "+ counter);

        String[] Instruments = new String[counter];
        for (int i = 1; i <= counter; i++) {
            Instruments[i - 1] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/app-sample-select[1]/div[1]/div[2]/div[1]/div[" + i + "]";
        }

        Random rnd = new Random();
        int randomElement = rnd.nextInt(Instruments.length);
        WebElement element = driver.findElement(By.xpath(Instruments[randomElement]));
        System.out.println("Randomly Selected Instrument: " + Instruments[randomElement]);
        element.click();
    }

    @Step("Random Straight Kick Drum Pattern")
    public void randomStraightKickDrumPattern(){

        String[] Kicks= new String[32];
        for (int i = 2; i <= 32; i++) {
            Kicks[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[1]/div[1]";
        }

        int [] Patterns = {0,1,2};
        Random rnd = new Random();
        int randomPattern = rnd.nextInt(Patterns.length);
        System.out.println("Randomly Selected Straight Kick Pattern: " + Patterns[randomPattern]);

        if(randomPattern==0){
            for (int boxes = 0; boxes <= 31; boxes+=8) {
                System.out.println("Selected Kick Box: " + Kicks[boxes]);
                WebElement element = driver.findElement(By.xpath(Kicks[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        if(randomPattern==1){
            for (int boxes = 2; boxes <= 29; boxes+=8) {
                System.out.println("Selected Kick Box: " + Kicks[boxes]);
                WebElement element = driver.findElement(By.xpath(Kicks[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        else if(randomPattern==2) {
            for (int boxes = 1; boxes <= 30; boxes +=3) {
                for (int j = 2; j <= 5; j++) {

                    System.out.println("Selected Kick Box: " + Kicks[boxes]);
                    WebElement element = driver.findElement(By.xpath(Kicks[boxes]));
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                    element.click();
                    Kicks[boxes] = Kicks[boxes + 2];
                }
            }
        }
    }

    @Step("Random Straight Snare Pattern")
    public void randomStraightSnarePattern() {

        String[] Snares = new String[32];

        for (int i = 2; i <= 32; i++) {
            Snares[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[2]/div[1]";
        }

        int [] Patterns = {0,1,2};
        Random rnd = new Random();
        int randomPattern = rnd.nextInt(Patterns.length);
        System.out.println("Randomly Selected Straight Snare Pattern: " + Patterns[randomPattern]);

        if(randomPattern==0){
            for (int boxes = 4; boxes <= 31; boxes+=8) {
                System.out.println("Selected Snare Box: " + Snares[boxes]);
                WebElement element = driver.findElement(By.xpath(Snares[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        if(randomPattern==1){
            for (int boxes = 2; boxes <= 29; boxes+=8) {
                System.out.println("Selected Snare Box: " + Snares[boxes]);
                WebElement element = driver.findElement(By.xpath(Snares[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        else if(randomPattern==2){
            for (int boxes = 0; boxes <= 31; boxes+=8) {
                System.out.println("Selected Snare Box: " + Snares[boxes]);
                WebElement element = driver.findElement(By.xpath(Snares[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }
    }

    @Step("Random Straight Closed HiHat Pattern")
    public void randomStraightClosedHiHatPattern(){

        String[] ClosedHiHats = new String[32];

        for (int i = 2; i <= 32; i++) {
            ClosedHiHats[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[3]/div[1]";
        }

        int [] Patterns = {0,1,2,3,4,5,6};
        Random rnd = new Random();
        int randomPattern = rnd.nextInt(Patterns.length);
        System.out.println("Randomly Selected Straight Closed HiHat Pattern: " + Patterns[randomPattern]);


        if(randomPattern==0) {
            for (int boxes = 1; boxes <= 30; boxes += 3) {
                for (int j = 2; j <= 5; j++) {

                    System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                    WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                    element.click();
                    ClosedHiHats[boxes] = ClosedHiHats[boxes + 2];
                }
            }
        }

        if(randomPattern==1){
            for (int boxes = 1; boxes <= 31; boxes +=4) {
                for (int j = 2; j <= 5; j++) {

                    System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                    WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                    element.click();
                    ClosedHiHats[boxes] = ClosedHiHats[boxes + 1] ;
                }
            }
        }

        if(randomPattern==2){
            for (int boxes = 0; boxes <= 31; boxes +=4) {
                System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        if(randomPattern==3){
            for (int boxes = 1; boxes <= 31; boxes +=4) {
                System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        if(randomPattern==4){
            for (int boxes = 2; boxes <= 31; boxes +=4) {
                System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        if(randomPattern==5){
            for (int boxes = 3; boxes <= 29; boxes +=4) {
                System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }

        else if(randomPattern==6){
            for (int boxes = 1; boxes <= 29; boxes +=2) {
                System.out.println("Selected Closed Hihat Box: " + ClosedHiHats[boxes]);
                WebElement element = driver.findElement(By.xpath(ClosedHiHats[boxes]));
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
                element.click();
            }
        }
    }

    @Step("Random Open Hihat Pattern")
    public void randomOpenHihatPattern() {

        String[] OpenHiHats = new String[32];

        for (int i = 2; i <= 32; i++) {
            OpenHiHats[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[4]/div[1]";
        }

        for (int boxes = 1; boxes <= 4; boxes++) {
            Random rnd = new Random();
            System.out.println("Randomly Selected Open HiHat Box: " + OpenHiHats[rnd.nextInt(OpenHiHats.length - 1)]);
            WebElement element = driver.findElement(By.xpath(OpenHiHats[rnd.nextInt(OpenHiHats.length - 1)]));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            element.click();
        }
    }

    @Step("Random Tom Pattern")
    public void randomTomPattern() {

        String[] Toms = new String[32];

        for (int i = 2; i <= 32; i++) {
            Toms[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[5]/div[1]";
        }

        for (int boxes = 1; boxes <= 4; boxes++) {
            Random rnd = new Random();
            System.out.println("Randomly Selected Tom Box: " + Toms[rnd.nextInt(Toms.length - 1)]);
            WebElement element = driver.findElement(By.xpath(Toms[rnd.nextInt(Toms.length - 1)]));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            element.click();
        }
    }

    @Step("Random Percussion Pattern")
    public void randomPercussionPattern() {

        String[] Percussions = new String[32];

        for (int i = 2; i <= 32; i++) {
            Percussions[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[6]/div[1]";
        }

        for (int boxes = 1; boxes <= 4; boxes++) {
            Random rnd = new Random();
            System.out.println("Randomly Selected Percussion Box: " + Percussions[rnd.nextInt(Percussions.length - 1)]);
            WebElement element = driver.findElement(By.xpath(Percussions[rnd.nextInt(Percussions.length - 1)]));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            element.click();
        }
    }

    @Step("Random FX Pattern")
    public void randomFXPattern() {

        String[] FXs = new String[32];

        for (int i = 2; i <= 32; i++) {
            FXs[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[7]/div[1]";
        }

        for (int boxes = 1; boxes <= 4; boxes++) {
            Random rnd = new Random();
            System.out.println("Randomly Selected FX Box: " + FXs[rnd.nextInt(FXs.length - 1)]);
            WebElement element = driver.findElement(By.xpath(FXs[rnd.nextInt(FXs.length - 1)]));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            element.click();
        }
    }

    @Step("Random Synth Hit Pattern")
    public void randomSynthHitPattern() {

        String[] SynthHits = new String[32];

        for (int i = 2; i <= 32; i++) {
            SynthHits[i - 2] = "//body/app-root[1]/div[1]/app-beatmaker[1]/div[1]/div[4]/app-tracks-viewport[1]/div[1]/app-grid[1]/div[1]/div[1]/div[" + i + "]/div[8]/div[1]";
        }

        for (int boxes = 1; boxes <= 2; boxes++) {
            Random rnd = new Random();
            System.out.println("Randomly Selected Synth Hit Box: " + SynthHits[rnd.nextInt(SynthHits.length - 1)]);
            WebElement element = driver.findElement(By.xpath(SynthHits[rnd.nextInt(SynthHits.length - 1)]));
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            element.click();
        }
    }
}
package spring1.core.singleton;

public class SingletonService {

    // 클래스 영역에 만들어지기 때문에 딱 1개만 만들어짐
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}

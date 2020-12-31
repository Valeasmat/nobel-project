package com.vale.javarx;

import com.vale.javarx.controller.RxController;
import com.vale.javarx.entity.*;
import com.vale.javarx.service.RxService;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Predicate;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private RxController controller;

    @Mock
    private RxService rxService;


    public Observable<LaureateInfo> init(){
        Observable<LaureateInfo> mock=Observable.just(
                new LaureateInfo("id1",
                        new Language("Laureate1"),
                        "Male",
                        new Fact("birth1",
                                new Place(new Language("Korea"),
                                        new Language("Asia"))),
                        new Fact("birth1",
                                new Place(new Language("Korea"),
                                        new Language("Asia")))),
                new LaureateInfo("id2",
                        new Language("Laureate2"),
                        "Female",
                        new Fact("birth2",
                                new Place(new Language("France"),
                                        new Language("Europe"))),
                        new Fact("death2",
                                new Place(new Language("France"),
                                        new Language("Europe")))),
                new LaureateInfo("id3",
                        new Language("Laureate3"),
                        "Female",
                        new Fact("birth3",
                                new Place(new Language("Italy"),
                                        new Language("Europe"))),
                        new Fact("death3",
                                new Place(new Language("Italy"),
                                        new Language("Europe")))));
        return mock;
    }


    @Test
    public void getLaureatesTest() throws Exception{

        Mockito.when(rxService.
                getLaureatesByCategoryAndYear(Mockito.anyString(),Mockito.anyInt()))
                .thenReturn(init());

        TestObserver<LaureateResponse> testObserver=controller
                .getLaureates("Physics",2005).test();

        testObserver
                .assertSubscribed()
                .assertNever(response->!response.getName().startsWith("Laurea"))
                .assertValueCount(3)
                .assertNoErrors();


    }
}

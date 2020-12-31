package com.vale.javarx;

import com.vale.javarx.clientapi.NobelClientApi;
import com.vale.javarx.entity.*;
import com.vale.javarx.service.RxService;
import com.vale.javarx.service.RxServiceImpl;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    private RxServiceImpl rxService;

    @Mock
    private NobelClientApi nobelClientApi;

    public Observable<List<NobelPrize>> init(){
        List<NobelPrize> init=Arrays.asList(
                new NobelPrize("2005",
                        new Language("Medicine"),
                        Arrays.asList(new Laureate(1),new Laureate(2))));
        return Observable.just(init);
    }
    public Observable<List<LaureateInfo>> init2(){
        List<LaureateInfo> init=Arrays.asList(
                new LaureateInfo("1",
                        new Language("Laureate1"),
                        "Male",
                        new Fact("birth1",
                                new Place(new Language("Korea"),
                                        new Language("Asia"))),
                        new Fact("birth1",
                                new Place(new Language("Korea"),
                                        new Language("Asia")))));
        return Observable.just(init);
    }
    public Observable<List<LaureateInfo>> init3(){
        List<LaureateInfo> init=Arrays.asList(
                new LaureateInfo("2",
                        new Language("Laureate2"),
                        "Female",
                        new Fact("birth2",
                                new Place(new Language("France"),
                                        new Language("Europe"))),
                        new Fact("birth2",
                                new Place(new Language("France"),
                                        new Language("Europe")))));
        return Observable.just(init);
    }

    @Test
    public void getLaureatesByCategoryAndYearTest(){
        Mockito.when(nobelClientApi
                .getNobelByCategoryandYear(Mockito.anyString(),Mockito.anyInt()))
                .thenReturn(init());
        Mockito.when(nobelClientApi
                .getLaureateInfo(1))
                .thenReturn(init2());
        Mockito.when(nobelClientApi
                .getLaureateInfo(2))
                .thenReturn(init3());

        Observable<LaureateInfo> medicine = rxService.getLaureatesByCategoryAndYear("Medicine", 2005);
        TestObserver<LaureateInfo> observer=medicine.test();

        observer
                .assertSubscribed()
                .assertNever(laureate->!(laureate.getGender().equals("Female")||
                        laureate.getGender().equals("Male")))
                .assertValueCount(2)
                .assertNoErrors();

    }

}

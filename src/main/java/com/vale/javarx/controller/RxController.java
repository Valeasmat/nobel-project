package com.vale.javarx.controller;

import com.vale.javarx.entity.LaureateResponse;
import com.vale.javarx.service.RxService;
import io.reactivex.Observable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
public class RxController {

    @Autowired
    private RxService rxService;

    @GetMapping(value = "laureatesCatYear/{category}/{year}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Observable<LaureateResponse> getLaureates(@PathVariable String category, @PathVariable Integer year) {
        return rxService.getLaureatesByCategoryAndYear(category,year)
                .map(x->new LaureateResponse(category,
                        year,
                        x.getFullName().getEnglish(),
                        x.getGender(),
                        x.getBirth().getPlace().getCountry().getEnglish()));
                //.concatMap(laureateResponse -> Observable.just(laureateResponse).delay(2, TimeUnit.SECONDS));

    }


}

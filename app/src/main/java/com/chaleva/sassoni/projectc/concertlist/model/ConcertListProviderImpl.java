package com.chaleva.sassoni.projectc.concertlist.model;

import com.chaleva.sassoni.projectc.Concert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchaleva on 3/30/16.
 */
public class ConcertListProviderImpl implements ConcertListProvider {
    @Override
    public List<Concert> loadConcerts() {
        return generatePlaceholderConcerts();
    }

    private List<Concert> generatePlaceholderConcerts() {
        Concert tool = new Concert();
        tool.setTitle("Tool");
        Concert savages = new Concert();
        savages.setTitle("Savages");
        Concert bruce = new Concert();
        bruce.setTitle("Bruce Springsteen");
        Concert acdc = new Concert();
        acdc.setTitle("ACDC");
        List<Concert> list = new ArrayList<>();
        list.add(tool);
        list.add(savages);
        list.add(bruce);
        list.add(acdc);
        list.add(tool);
        list.add(savages);
        list.add(bruce);
        list.add(acdc);
        list.add(tool);
        list.add(savages);
        list.add(bruce);
        list.add(acdc);
        list.add(tool);
        list.add(savages);
        list.add(bruce);
        list.add(acdc);
        list.add(tool);
        list.add(savages);
        list.add(bruce);
        list.add(acdc);
        return list;
    }
}

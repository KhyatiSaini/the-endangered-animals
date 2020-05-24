package com.example.theanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StatisticsFragment extends Fragment implements StatAdapter.ImageClicked{

    private RecyclerView statRecyclerView;
    private StatAdapter statAdapter;
    private ArrayList<StatModel> statList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment, container, false);
        statRecyclerView = view.findViewById(R.id.recyclerViewStat);

        addingStats();
        buildRecyclerViewStat();

        return view;
    }

    private void buildRecyclerViewStat() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        statRecyclerView.setLayoutManager(linearLayoutManager);
        statAdapter = new StatAdapter(statList, getContext(), this);
        statRecyclerView.setAdapter(statAdapter);
    }

    private void addingStats() {
        statList = new ArrayList<>();
        statList.add(new StatModel(R.drawable.amurleopard, "Amur Leopard", "The IUCN Species Survival Commission has considered Amur leopards Critically Endangered (IUCN 1996) since 1996. As of 2019, more than 84 individuals remain in the wild (mostly in protected areas) and 170 to 180 live in captivity."));
        statList.add(new StatModel(R.drawable.asianelephant, "Asian Elephant", "The Asian elephant is classified as Endangered by the International Union for the Conservation of Nature (IUCN). Its population has declined by an estimated 50 percent over the past 75 years, and there are an estimated 20,000 to 40,000 Asian elephants left in the wild."));;
        statList.add(new StatModel(R.drawable.blackrhinos, "Black Rhinos", "The population currently numbers just over 5,000 individuals, although three subspecies have already been declared extinct. They are primarily threatened by illegal poaching, driven largely by demand for rhino horn on the black market."));
        statList.add(new StatModel(R.drawable.bluewhale, "Blue Whale", "There is one population of around 2,000 blue whales off the coast of California – but all there are only around 10,000 to 25,000 individuals left. The World Conservation Union (IUCN) Red List rates them as Endangered."));
        statList.add(new StatModel(R.drawable.borneanorangutan, "Bornean Orangutan", "A century ago there were probably more than 230,000 orangutans in total, but the Bornean orangutan is now estimated at about 104,700 based on updated geographic range (Endangered) and the Sumatran about 7,500 (Critically Endangered)."));
        statList.add(new StatModel(R.drawable.crossrivergorilla, "Cross River Gorilla", "Because the gorillas are wary of humans and inhabit rugged territory, scientists have been unable to count many of these gorillas directly. Instead, researchers have used indirect signs, such as nest counts, and estimated range sizes to determine that there are currently only 200-300 Cross River Gorillas left in the wild, making them the most endangered great ape in Africa."));
        statList.add(new StatModel(R.drawable.giantpanda, "Giant Panda", "The World Wildlife Fund (WWF) says there are just 1,864 pandas left in the wild. There are an additional 400 pandas in captivity, according to Pandas International."));
        statList.add(new StatModel(R.drawable.gorilla, "Gorilla", "Since their scientific discover in 1902, the population of the mountain gorillas has bee on a steady decline and there are currently about 700 to 880 mountain gorillas left in the world, and these can only survive in the wild."));
        statList.add(new StatModel(R.drawable.hawksbilturtle, "Hawksbill Turtle", "Hawksbill turtles are currently classified as Critically Endangered by the IUCN (the global authority on the status of the natural world). Alongside Kemp's Ridley's, they are believed to be the most endangered of the seven species of sea turtle, with only approximately 8,000 nesting females left globally."));
        statList.add(new StatModel(R.drawable.javanrhino, "Javan Rhino", "Even the most optimistic estimate suggests fewer than 100 Javan rhinos remain in the wild. They are considered one of the most endangered species in the world. The Javan rhinoceros is known to survive in only one place, the Ujung Kulon National Park on the western tip of Java."));
        statList.add(new StatModel(R.drawable.lowlandgorilla, "Eastern Lowland Gorilla", "Today, mainly due to habitat loss and illegal poaching, the eastern lowland gorilla is considered to be a species that is in danger of becoming extinct in the wild forever. There are estimated to be around 5,000 eastern lowland gorillas."));
        statList.add(new StatModel(R.drawable.orangutan, "Orangutan", "A century ago there were probably more than 230,000 orangutans in total, but the Bornean orangutan is now estimated at about 104,700 based on updated geographic range (Endangered) and the Sumatran about 7,500 (Critically Endangered)."));
        statList.add(new StatModel(R.drawable.porpoise, "Yangzte Finless Porpoise", "There are 1,040 finless porpoises left in the Yangtze. The annual decline rate of 13 percent means these animals are expected to become extinct within 10 years if there are no effective conservation actions in place. The new classification is a step in the right direction to save the species."));
        statList.add(new StatModel(R.drawable.saola, "Saola", "The saola (Pseudoryx nghetinhensis) is listed as critically endangered by the International Union for Conservation of Nature (IUCN). Formal surveys have yet to be taken to determine accurate population numbers, but the IUCN estimates the total population to be between 70 and 750 and declining."));
        statList.add(new StatModel(R.drawable.seaotters, "Sea Otters", "The 2019 population is at 2,962 — 166 fewer otters than in 2018, the study said. The population has declined slightly each year since it hit a peak of 3,272 in 2016. As of now, there are only about 3,000 southern sea otters left in the wild."));
        statList.add(new StatModel(R.drawable.siberiantiger, "Siberian Tiger", "Only about 500 Siberian tigers remain in eastern Russia and the bordering regions. Habitat loss and poaching threaten the dwindling population, but one group is focused on protecting the tigers."));
        statList.add(new StatModel(R.drawable.snowleopard, "Snow Leopard", "There are an estimated 4,080-6,590 snow leopards in the wild. They are listed as endangered by the International Union for Conservation of Nature (IUCN) because their population is suspected to have declined by 20% over the past 16 years."));
        statList.add(new StatModel(R.drawable.sumatranelephant, "Sumatran Elephant", "The island of Sumatra is located within Indonesia, and contains a wide range of animal and plant species. Unfortunately many of these species have become endangered as a result of tropical forest loss. Currently, there are only 2,400-2,800 Sumatran Elephants left."));
        statList.add(new StatModel(R.drawable.sumatranorangutan, "Sumatran Orangutan", "With 104,700 individuals left in the wild, it's listed as endangered. And there's the Sumatran orangutan (Pongo abelii), its habitat now restricted to the northern part of that Indonesian island. With only 7,500 individuals left, it's listed as critically endangered."));
        statList.add(new StatModel(R.drawable.sumatranrhino,"Sumatran Rhinos", "There are now only less than 80 Sumatran rhinos left in the wild, and efforts are now being invested in captive breeding in an attempt to boost the population."));
        statList.add(new StatModel(R.drawable.sumatrantiger, "Sumatran Tiger", "It is estimated that only between 500-600 Sumatran tigers remain in the wild, and the actual number may be as low as 400. And their population is dwindling rapidly. A 1978 a tiger census reported around 1,000 Sumatran tigers still in the wild."));
        statList.add(new StatModel(R.drawable.tasmaniandevil, "Tasmanian Devil", " The population size in 2007 estimated at 25,000 adult devils but the total number of devils found to be around 50,000 individuals. In 2004 there were approximately 21,000 Tasmanian devils remaining in the wild."));
        statList.add(new StatModel(R.drawable.vaquita, "Vaquita", "The latest report by the International Committee for the Recovery of the Vaquita (CIRVA) estimates that only between 6 and 22 individuals remained alive in 2018. It is possible, though, that there no more than 10 vaquitas left."));
        statList.add(new StatModel(R.drawable.westrenlowlandgorilla, "Western Lowland Gorilla", "The western lowland gorilla is the most widespread and numerous of the four gorilla subspecies. No accurate estimates of their numbers are possible, as these elusive apes inhabit some of Africa's densest and most remote rainforests. However, the total population is thought to number up to 100,000 individuals."));
        statList.add(new StatModel(R.drawable.whoopingcranes, "Whooping Cranes", "According to the report produced by the International Crane Foundation, the current estimated population size is 85 (41 F, 41 M, 3 U). Fourteen of these 85 individuals are wild-hatched and the rest are captive-reared."));
    }

    @Override
    public void imageClicked(StatModel statModel, Context context) {
        Intent intent = new Intent(getContext(), ImageActivity.class);
        intent.putExtra("Image", statModel.getImageResource());
        Log.e("Statistics Fragment", "selectedImage: " + statModel.getAnimalName());
        startActivity(intent);
    }
}

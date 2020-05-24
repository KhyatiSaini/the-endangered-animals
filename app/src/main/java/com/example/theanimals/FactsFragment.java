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

public class FactsFragment extends Fragment implements FactsAdapter.SelectedImage{

    private RecyclerView factsRecyclerView;
    private FactsAdapter factsAdapter;
    private ArrayList<FactsModel> factsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.facts_fragment, container, false);
        factsRecyclerView = view.findViewById(R.id.recyclerViewFacts);

        addingFacts();
        buildRecyclerViewFacts();

        return view;
    }

    private void buildRecyclerViewFacts() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        factsRecyclerView.setLayoutManager(linearLayoutManager);
        factsAdapter = new FactsAdapter(factsList, getContext(), this);
        factsRecyclerView.setAdapter(factsAdapter);
    }

    private void addingFacts() {
        factsList = new ArrayList<>();
        factsList.add(new FactsModel(R.drawable.amurleopard, "Amur leopards can run at speeds of 36 mph over short distances. These leopards can leap 10 feet (3 m) vertically. Unlike other cats, leopards are strong swimmers and are one of the few cats that like water.\n\n" +
                "The Amur leopard is adapted to the cool climate by having thick fur which grows up to 7.5 cm long in winter. For camouflage in the snow, their coat is paler than other leopard subspecies. The Amur leopard's rosettes are widely spaced and larger than those seen on other leopards.\n\n" +
                "Amur leopards are carnivores. They are opportunistic so are not fussy eaters, but prey consists mainly of roe and sika deer, hares, wild pigs and badgers. Although, when feeling brave, they have been known to eat young black bears.", "Amur Leopard"));
        factsList.add(new FactsModel(R.drawable.asianelephant, "Asian elephants can tear down trees or pick up a blade of grass with their trunks.\n\n" +
                "Elephants have the largest brain of any land mammal. In fact, of all land mammals, they have greatest volume of cerebral cortex available for cognitive processing.\n\n" +
                "An elephant’s trunk has more than 40,000 muscles, more than all the muscles in a human body! Asian elephants have a gestation period of almost 22 months—the longest of any animal. Calves often nurse for two to four years.", "Asian Elephant"));
        factsList.add(new FactsModel(R.drawable.blackrhinos, "Rhinoceros is a Greek word. ‘Rhino’ means ‘nose’ and ‘ceros’ means ‘horn’.\n\n" +
                "Black rhinos have a ‘prehensile’, meaning hooked, lip for pulling leaves off branches.\n\n" +
                "Rhinos run on their toes. That’s a lot of weight to carry!\n\n" +
                "As the saying goes, rhinos do have thick skin, but they can still get sun burnt.\n\n" +
                "Black rhinos are the third biggest of the five types of rhino.\n\n" +
                "Black rhinos love eating plants. Up to 220 different types!", "Black Rhinos"));
        factsList.add(new FactsModel(R.drawable.bluewhale, "The Blue Whale is the largest animal ever to have lived on earth.\n\n" +
                "Despite being so massive, this giant of the ocean feeds on some of the smallest marine life – tiny shrimp like animals called krill. A single adult blue whale can consume 36,000 kg of krill a day.\n\n" +
                "Incredibly, Blue Whales are graceful swimmers cruise the ocean at over 8km/h, and can reach speeds of over 30km/h.", "Blue Whale"));
        factsList.add(new FactsModel(R.drawable.borneanorangutan, "Orangutans are the largest tree-dwelling animals on Earth. Though adult male gorillas climb up to the canopy to feed, they do not spend much time there and are basically terrestrial.\n\n" +
                "Daytime eaters, their diet consists mostly of fruit and leaves – but they also eat nuts, bark, insects and, once in a while, bird eggs, too.\n\n" +
                "These amazing apes generally have long lives – in captivity they can live for 50-60 years, and in the wild, 30-40 years.", "Bornean Orangutan"));
        factsList.add(new FactsModel(R.drawable.crossrivergorilla, "The Cross River Gorilla is a subspecies of the Western Gorilla.\n\n" +
                "There are currently only 200-300 Cross River Gorillas left in the wild, making them the most endangered great ape in Africa.\n\n" +
                "They live in mountainous border area between Cameroon and Nigeria at the top of the Cross River, after which they are named.", "Cross River Gorilla"));
        factsList.add(new FactsModel(R.drawable.giantpanda, "Pandas have carnivorous teeth, but they eat bamboo and fruit.\n\n" +
                "Giant pandas are good tree climbers. They can climb trees from 7 months old, they are bears, and like other bears, they can swim.\n\n" +
                "Pandas are born looking like baby badgers — fur-less, pink, and blind. The iconic black and white colour comes later, after about three weeks.\n\n" +
                "Not all giant pandas are black and white! A few are brown and white, but these are very rare.", "Giant Panda"));
        factsList.add(new FactsModel(R.drawable.gorilla, "Gorillas have hands and feet like humans including opposable thumbs and big toes.\n\n" +
                "Some gorillas in captivity have learned to use sign language to communicate with humans.\n\n" +
                "They sleep at night in nests", "Gorilla"));
        factsList.add(new FactsModel(R.drawable.hawksbilturtle, "The hawksbill sea turtle frequents coral reefs.\n\n" +
                "Hawksbill sea turtles are critically endangered.\n\n" +
                "Hawksbill sea turtle shells change colors.\n\n" +
                "Hawksbills almost exclusively eat sponges.\n\n" +
                "These turtles are solitary.", "Hawksbill Turtle"));
        factsList.add(new FactsModel(R.drawable.javanrhino, "All 67 Javan rhinos have names – one of them is called Rawing!\n\n" +
                "They're heavy animals, weighing up to 2.3 tonnes.\n\n" +
                "They live to around 30-45 years in the wild.\n\n" +
                "They're herbivorous, only eating plants.\n\n" +
                "They're solitary animals, except for mating pairs and mothers with young.", "Javan Rhino"));
        factsList.add(new FactsModel(R.drawable.lowlandgorilla, "The largest eastern lowland gorillas are in zoos, and they can reach more than 250 kilograms.\n\n" +
                "They have a strong skeleton with a big skull compared to the size of the rest of their body, a short snout and a jawbone with teeth.\n\n" +
                "Their arms are long and very developed, longer in males than in females.", "Eastern Lowland Gorilla"));
        factsList.add(new FactsModel(R.drawable.orangutan, "Orangutans are red-haired apes that live in the tropical rainforests of Sumatra and Borneo in southeast Asia.\n\n" +
                "These magnificent mammals measure 1.2m to 1.5m tall and weigh up to 100kg.\n\n" +
                "The orangutan is one of humankind's closest relatives – in fact, we share nearly 97% of the same DNA!", "Orangutan"));
        factsList.add(new FactsModel(R.drawable.porpoise, "The Yangtze finless porpoise is a small mammal that can be found in the Yangtze River in China.\n\n" +
                "Unlike most porpoises they don't have a fin on their back or a beak. They have a rounded head and are a dark to pale grey colour.\n\n" +
                "Males reach sexual maturity at four to six years of age, and females at six to nine years. Finless porpoises have lived up to 33 years.", "Yangtze Finless Porpoise"));
        factsList.add(new FactsModel(R.drawable.saola, "The Saola, pronounced sow-la, meaning ‘spindle horns’ in Vietnamese, is found in only one place in the world: the Annamite Mountains forests on the border between Vietnam and Laos.\n\n" +
                "Saola is a large animal that looks like antelope, but it is more closely related to bovine family. It can reach 59 to 77 inches in length and weight between 176 and 220 pounds.\n\n" +
                "Both males and females have long, sharp, parallel positioned horns that can reach 20 inches in length.", "Saola"));
        factsList.add(new FactsModel(R.drawable.seaotters, "Thirteen different species of otter exist all around the world. Some are small river otters, and some are bigger sea otters, 90% of all sea otters live on the coast of Alaska.\n\n" +
                "They're hungry animals! Sea otters eat 25% of their body weight in food every day.\n\n" +
                "Clever creatures, they'll use rocks to crack open the clams. They carry rocks and store food in the loose skin under their armpits - who needs carrier bags! ", "Sea Otter"));
        factsList.add(new FactsModel(R.drawable.siberiantiger, "Siberian or Amur tiger’s skull resembles skull of a lion except for the lower jaw which is slightly different. The biggest skull ever measured of a Siberian tiger reaches a length of 406 mm (16.0 in). The skull is from the specimen found in the northeast China.\n\n" +
                "Amur tigers will travel as much as 620 miles within the country.\n\n" +
                "The maximum lifespan of a captive amur tiger is estimated at 25 years.", "Siberian Tiger"));
        factsList.add(new FactsModel(R.drawable.snowleopard, "Snow leopards are the only big cats that call the cold deserts of Asia home. These deserts are also known as the third pole because they contain ice fields with the largest reserves of freshwater outside the northern and southern polar regions.\n\n" +
                "They are often called the “ghosts of the mountain” because they are so rarely seen and spend most of their lives in solitude.\n\n" +
                "They can prey on animals up to three times their own body weight.", "Snow Leopard"));
        factsList.add(new FactsModel(R.drawable.sumatranelephant, "The Sumatran Elephant is the smallest subspecies, but the largest mammal existing on the island of Sumatra. They can weigh up to 5tonnes and reach 9ft in height!\n\n" +
                "Adult elephants can drink 80 – 200 liters of water each day. They will eat 112 different plants species.\n\n" +
                "Sumatran Elephants are the largest terrestrial animals of Indonesia. They are only found on the island of Sumatra. The skin coloration of the Sumatran Elephant is lighter than the other two subspecies of Asian Elephant.", "Sumatran Elephant"));
        factsList.add(new FactsModel(R.drawable.sumatranorangutan, "The Sumatran Orangutan are now found only in the dense, tropical and northern forests of the Indonesian island of Sumatra.\n\n" +
                "Physically the hair of the Sumatran orangutans is paler and more ‘golden’ in colour.\n\n" +
                "The cheek flanges of Sumatran males, like Puluh, grow so their faces become rounded and dish shaped and covered in small fine hairs.", "Sumatran Orangutan"));
        factsList.add(new FactsModel(R.drawable.sumatranrhino, "The remaining populations of the rare Sumatran Rhino, also known as Hairy Rhino or Asian Two-Horned Rhino, can be found in the hilly areas of tropical rain-forests on the Indonesian island of Sumatra and the Kalimantan province of Borneo.\n\n" +
                "For the first time in 40 years, the Sumatran Rhino was spotted in Borneo.\n\n" +
                "It is the smallest and the hairiest of the of the rhino family. Usually, their reddish-brown skin is covered in patches of short, dark coarse hair with longer, thicker hair around their ears and tail.", "Sumatran Rhino"));
        factsList.add(new FactsModel(R.drawable.sumatrantiger, "These beautiful tigers grow up to 2.5 metres long, making them the smallest subspecies of tiger in the world.\n\n" +
                "Sumatran tigers are different from other tigers in that they have thinner stripes and larger manes.\n\n" +
                "They are excellent hunters and mainly catch deer, wild pigs, cattle and goats.", "Sumatran Tiger"));
        factsList.add(new FactsModel(R.drawable.tasmaniandevil, "The Tasmanian devil is the largest surviving carnivorous marsupial. It has a squat, thick build, with a large head and a tail which is about half its body length.\n\n" +
                "Unusually for a marsupial, its forelegs are slightly longer than its hind legs, and devils can run up to 13 km/h (8.1 mph) for short distances.\n\n" +
                "devils are not dangerous. They do not attack people, although they will defend themselves if they're attacked or trapped. Devils may look fierce but they will much rather escape than fight. However, devils have powerful jaws and when they do bite, they can cause serious injury.", "Tasmanian Devil"));
        factsList.add(new FactsModel(R.drawable.vaquita, "The vaquita, Phocoena sinus, is the world's smallest cetacean, weighing around 55 kilos.\n\n" +
                "Females grow to be around 1.5 metres long.\n\n" +
                "They eat small fish and squid.\n\n" +
                "They have unique facial markings with a black ring around each eye and curved, black lips that make them look as if they are smiling.", "Vaquita"));
        factsList.add(new FactsModel(R.drawable.westrenlowlandgorilla, "Western lowland gorillas are the smallest gorillas. Males are considerably larger than females. An adult male weighs between 136 and 227 kg (300 to 500 lbs) and stands up to 1.8 m (6 ft) tall. Females weigh between 68 and 90 kg (150 to 200 lb) and stand around 1.4 m (4.5 ft) tall.\n\n" +
                "Relatively small gorilla with dark brownish black hair and large skull. Mature males have white hair on their backs.\n\n" +
                "Western lowland gorillas are herbivores. They preferentially select fruit that is high in sugar and fiber. However, when fruit is scarce, they eat leaves, shoots, herbs, and bark. An adult gorilla eats about 18 kg (40 lb) of food per day.", "Western Lowland Gorilla"));
        factsList.add(new FactsModel(R.drawable.whoopingcranes, "The Whooping Crane is the tallest bird in North America and the rarest crane species.\n\n" +
                "Adult Whooping Cranes are identified by a red skin patch on their forehead, black “mustache” and legs, and black wing tips visible in flight.\n\n" +
                "The whooping crane (Grus americana) is the tallest bird in North America, they are named for their whooping unison calls.", "Whooping Crane"));
    }

    @Override
    public void selectedImage(FactsModel factsModel, Context context) {
        Intent intent = new Intent(getContext(), ImageActivity.class);
        intent.putExtra("Image", factsModel.getAnimalImageResource());
        Log.e("Facts Fragment", "selectedImage: " + factsModel.getAnimalName());
        startActivity(intent);
    }
}

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

public class Home_Fragment extends Fragment implements Home_Adapter.SelectedAnimalHome{

    private RecyclerView homeRecyclerView;
    private Home_Adapter homeAdapter;
    private ArrayList<Home_Model> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        homeRecyclerView = view.findViewById(R.id.recyclerViewHome);

        addingDataHome();
        buildRecyclerViewHome();

        return view;
    }

    private void buildRecyclerViewHome() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeAdapter = new Home_Adapter(list, getContext(), this);
        homeRecyclerView.setAdapter(homeAdapter);
    }

    private void addingDataHome() {
        list = new ArrayList<>();
        list.add(new Home_Model(R.drawable.amurleopard,"Amur Leopard",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.blackrhinos,"Black Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.orangutan,"Bornean Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.crossrivergorilla,"Cross River Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.lowlandgorilla,"Eastern Lowland Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.hawksbilturtle,"Hawksbill Turtle",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.javanrhino,"Javan Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.orangutan,"Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.saola,"Saola",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranelephant,"Sumatran Elephant",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranorangutan,"Sumatran Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranrhino,"Sumatran Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.siberiantiger,"Sunda Tiger",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.vaquita,"Vaquita",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.westrenlowlandgorilla,"Western Lowland Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.porpoise,"Yangtze Finless Porpoise",R.drawable.arrow));
    }


    @Override
    public void selectedAnimalHome(Home_Model homeModel, Context context, int position) {
        Intent intent1 = new Intent(getContext(), InfoActivity.class);
        intent1.putExtra("ImageURL", homeModel.getAnimalImageResource());
        intent1.putExtra("AnimalName", homeModel.getNameOfAnimal());
        intent1.putExtra("AnimalInfo", info[position]);
        intent1.putExtra("AnimalStatus", status[position]);
        Log.e("inside SAH", "info : " + String.valueOf(info.length));
        startActivity(intent1);
    }

    String[] info = {"People usually think of leopards in the savannas of Africa but in the Russian Far East, a rare subspecies has adapted to life in the temperate forests that make up the northern-most part of the species’ range. Similar to other leopards, the Amur leopard can run at speeds of up to 37 miles per hour. This incredible animal has been reported to leap more than 19 feet horizontally and up to 10 feet vertically.\n" +
            "\n" +
            "The Amur leopard is solitary. Nimble-footed and strong, it carries and hides unfinished kills so that they are not taken by other predators. It has been reported that some males stay with females after mating, and may even help with rearing the young. Several males sometimes follow and fight over a female. They live for 10-15 years, and in captivity up to 20 years. The Amur leopard is also known as the Far East leopard, the Manchurian leopard or the Korean leopard.",
            "Black rhinos are the smaller of the two African rhino species. The most notable difference between white and black rhinos are their hooked upper lip. This distinguishes them from the white rhino, which has a square lip. Black rhinos are browsers rather than grazers, and their pointed lip helps them feed on leaves from bushes and trees. They have two horns, and occasionally a third, small posterior horn.\n" +
                    "\n" +
                    "Populations of black rhino declined dramatically in the 20th century at the hands of European hunters and settlers. Between 1960 and 1995, black rhino numbers dropped by a sobering 98%, to less than 2,500. Since then, the species has made a tremendous comeback from the brink of extinction. Thanks to persistent conservation efforts across Africa, black rhino numbers have doubled from their historic low 20 years ago to between 5,042 and 5,455 today. However, the black rhino is still considered critically endangered, and a lot of work remains to bring the numbers up to even a fraction of what it once was—and to ensure that it stays there. Wildlife crime—in this case, poaching and black-market trafficking of rhino horn—continues to plague the species and threaten its recovery.\n",
            "Bornean orangutan populations have declined by more than 50% over the past 60 years, and the species' habitat has been reduced by at least 55% over the past 20 years.\n" +
                    "\n" +
                    "The Bornean orangutan differs in appearance from the Sumatran orangutan, with a broader face and shorter beard and also slightly darker in color. Three subspecies are recognized, each localized to different parts of the island:\n" +
                    "\n" +
                    "Northwest Bornean orangutans are the most threatened subspecies. Its habitat has been seriously affected by logging and hunting, and a mere 1,500 individuals or so remain. Many habitat patches in the area are small and fragmented.\n" +
                    "Northeast Bornean orangutans are the smallest in size and found in Sabah and eastern Kalimantan as far as the Mahakam River.\n" +
                    "Central Bornean orangutans are the subspecies with the most animals, with at least 35,000 individuals.\n",
            "Scientists have been unable to thoroughly study the distribution and abundance of the Cross River gorilla until the last decade or so. Because the gorillas are wary of humans and inhabit rugged territory, scientists have been unable to count many of these gorillas directly. Instead, researchers have used indirect signs, such as nest counts, and estimated range sizes to determine that there are only about 200 to 300 of these gorillas left in the wild. Cross River gorillas are scattered in at least 11 groups across the lowland montane forests and rainforests of Cameroon and Nigeria, an area of 3,000 square miles, or about twice the size of Rhode Island.\n" +
                    "\n" +
                    "This subspecies of the western gorilla is very similar in appearance to the more numerous western lowland gorilla, but subtle differences can be found in the skull and tooth dimensions. Cross River gorillas live in a region populated by many humans who have encroached upon the gorilla’s territory—clearing forests for timber and to create fields for agriculture and livestock. Poaching occurs in the forests as well, and the loss of even a few of these gorillas has a detrimental effect on such a small population.\n" +
                    "\n" +
                    "Efforts to protect these animals are focused on securing the forests that house them. WWF and partners have worked with the governments of Cameroon and Nigeria to create a protected area for the Cross River gorilla that spans the border of these two nations.\n",
            "The eastern lowland gorilla—also known as Grauer’s gorilla—is the largest of the four gorilla subspecies. It is distinguished from other gorillas by its stocky body, large hands and short muzzle. Despite its size, eastern lowland gorillas subsist mainly on fruit and other herbaceous materials, just like other gorilla subspecies.\n" +
                    "\n" +
                    "Years of civil unrest in the Democratic Republic of Congo (DRC) have taken their toll on both the eastern lowland gorilla and the mountain gorilla. The eastern lowland gorilla makes its home in lowland tropical rainforests in the eastern DRC. In the last 50 years, its range has decreased from 8,100 square miles—about the size of the state of Massachusetts— to about 4,600 square miles today. This subspecies may now occupy only 13% of its historical range. There were nearly 17,000 eastern lowland gorillas in the mid-1990s but scientists estimate that the population has declined by more than 50% since then. An accurate accounting of the animals has been impossible for many years because of violence in the region.\n" +
                    "\n" +
                    "Throughout the unrest, the gorillas have been vulnerable to poaching, even in Kahuzi-Biega National Park, home to the largest population of protected eastern lowland gorillas. Rebels and poachers invaded the park and people set up illegal mines. But, with help from WWF and other organizations, park staff are reestablishing control over the land.\n",
            "Hawksbills are named for their narrow, pointed beak. They also have a distinctive pattern of overlapping scales on their shells that form a serrated-look on the edges. These colored and patterned shells make them highly-valuable and commonly sold as \"tortoiseshell\" in markets.\n" +
                    "\n" +
                    "Hawksbills are found mainly throughout the world's tropical oceans, predominantly in coral reefs. They feed mainly on sponges by using their narrow pointed beaks to extract them from crevices on the reef, but also eat sea anemones and jellyfish. Sea turtles are the living representatives of a group of reptiles that has existed on Earth and travelled our seas for the last 100 million years. They are a fundamental link in marine ecosystems and help maintain the health of coral reefs and sea grass beds.\n",
            "Javan rhinos are the most threatened of the five rhino species, with only 58-68 individuals that live only in Ujung Kulon National Park in Java, Indonesia. Javan rhinos once lived throughout northeast India and Southeast Asia. Vietnam’s last Javan rhino was poached in 2010.\n" +
                    "\n" +
                    "This species is a dusky grey color and has a single horn of up to about 10 inches. Its skin has a number of loose folds, giving the appearance of armor plating. The Javan rhino is very similar in appearance to the closely-related greater one-horned rhinoceros, but has a much smaller head and less apparent skin folds.\n",
            "Known for their distinctive red fur, orangutans are the largest arboreal mammal, spending most of their time in trees. Long, powerful arms and grasping hands and feet allow them to move through the branches. These great apes share 96.4% of our genes and are highly intelligent creatures.\n" +
                    "\n" +
                    "The name orangutan means \"man of the forest\" in the Malay language. In the lowland forests in which they reside, orangutans live solitary existences. They feast on wild fruits like lychees, mangosteens, and figs, and slurp water from holes in trees. They make nests in trees of vegetation to sleep at night and rest during the day. Adult male orangutans can weigh up to 200 pounds. Flanged males have prominent cheek pads called flanges and a throat sac used to make loud verbalizations called long calls. An unflanged male looks like an adult female. In a biological phenomenon unique among primates, an unflanged male can change to a flanged male for reasons that are not yet fully understood.\n" +
                    "\n" +
                    "Bornean and Sumatran orangutans differ a little in appearance and behavior. While both have shaggy reddish fur, Sumatran orangutans have longer facial hair. Sumatran orangutans are reported to have closer social bonds than their Bornean cousins. Bornean orangutans are more likely to descend from the trees to move around on the ground. Both species have experienced sharp population declines. A century ago there were probably more than 230,000 orangutans in total, but the Bornean orangutan is now estimated at about 104,700 based on updated geographic range (Endangered) and the Sumatran about 7,500 (Critically Endangered).\n" +
                    "\n" +
                    "A third species of orangutan was announced in November, 2017. With no more than 800 individuals in existence, the Tapanuli orangutan is the most endangered of all great apes.\n",
            "The saola was discovered in May 1992 during a joint survey carried out by the Ministry of Forestry of Vietnam and WWF in north-central Vietnam. The team found a skull with unusual long, straight horns in a hunter's home and knew it was something extraordinary. The find proved to be the first large mammal new to science in more than 50 years and one of the most spectacular zoological discoveries of the 20th century.\n" +
                    "\n" +
                    "Saola (pronounced: sow-la) are recognized by two parallel horns with sharp ends, which can reach 20 inches in length and are found on both males and females. Meaning “spindle horns” in Vietnamese, they are a cousin of cattle but resemble an antelope. Saola have striking white markings on the face and large maxillary glands on the muzzle, which could be used to mark territory or attract mates. They are found only in the Annamite Mountains of Vietnam and Laos.\n",
            "Sumatran elephants feed on a variety of plants and deposit seeds wherever they go, contributing to a healthy forest ecosystem. They also share their lush forest habitat with several other endangered species, such as the Sumatran rhino, tiger, and orangutan, and countless other species that all benefit from an elephant population that thrives in a healthy habitat.\n",
            "The Sumatran orangutan is almost exclusively arboreal, living among the trees of tropical rainforests. Females virtually never travel on the ground and adult males do so rarely. Sumatran orangutans are reported to have closer social ties than their Bornean cousins. This has been attributed to mass fruit on fig trees, where groups of Sumatran orangutans can come together to feed. Adult males are typically solitary while females are accompanied by offspring.\n" +
                    "\n" +
                    "Historically, the Sumatran orangutan was distributed over the entire island of Sumatra and further south into Java. The species' range is now restricted to the north of the island with a majority in the provinces of North Sumatra and Aceh. Of the nine existing populations of Sumatran orangutans, only seven have prospects of long-term viability, each with an estimated 250 or more individuals. Only three populations contain more than 1,000 orangutans. Orangutans that were confiscated from the illegal trade or as pets are being reintroduced to Bukit Tigapuluh National Park. They number around 70 and are reproducing. \n",
            "Sumatran rhinos are the smallest of the living rhinoceroses and the only Asian rhino with two horns. They are covered with long hair and are more closely related to the extinct woolly rhinos than any of the other rhino species alive today. Calves are born with a dense covering that turns reddish-brown in young adults and becomes sparse, bristly and almost black in older animals. Sumatran rhinos compete with the Javan rhino for the unenviable title of most threatened rhino species. While surviving in possibly greater numbers than the Javan rhino, Sumatran rhinos are more threatened due to habitat loss and fragmentation. The remaining animals survive in small, fragmented non-viable populations, and with limited possibilities to find each other to breed, its population decline continues. Just two captive females have reproduced in the last 15 years.\n" +
                    "\n" +
                    "The Sumatran rhino once roamed as far away as the foothills of the Eastern Himalayas in Bhutan and eastern India, through Myanmar, Thailand, possibly to Vietnam and China, and south through the Malay Peninsula. Today, the species only survives on the Indonesian islands of Sumatra and Borneo. Experts believe the third subspecies is probably extinct.\n",
            "Sunda tigers are distinguished by heavy black stripes on their orange coats. The last of the Sunda island tigers—estimated to be fewer than 400 today—are holding on for survival in the remaining patches of forest on the island of Sumatra. Accelerating deforestation and rampant poaching mean this noble creature could end up extinct like its Javan and Balinese counterparts.\n" +
                    "\n" +
                    "In Indonesia, anyone caught hunting tigers could face jail time and steep fines. But despite increased efforts in tiger conservation—including strengthening law enforcement and antipoaching capacity—a substantial market remains in Sumatra and other parts of Asia for tiger parts and products. Sunda tigers are losing their habitat and prey fast, and poaching is an ever-present threat.\n",
            "Vaquita, the world's rarest marine mammal, is on the edge of extinction. The plight of cetaceans—whales, dolphins, and porpoises—as a whole is exemplified by the rapid decline of the vaquita in Mexico, with about 10 individuals remaining. This little porpoise wasn't discovered until 1958 and a little over half a century later, we are on the brink of losing them forever. Vaquita are often caught and drowned in gillnets used by illegal fishing operations in marine protected areas within Mexico's Gulf of California. The population has dropped drastically in the last few years.\n" +
                    "\n" +
                    "The vaquita has a large dark ring around its eyes and dark patches on its lips that form a thin line from the mouth to the pectoral fins. Its top—the dorsal surface—is dark gray, its sides are pale gray, and its underside—the ventral surface—is white with long, light gray markings. Newborn vaquita have darker coloration and a wide gray fringe of color that runs from the head to the flukes, passing through the dorsal and pectoral fins. They are most often found close to shore in the Gulf's shallow waters, although they quickly swim away if a boat approaches.\n",
            "The western lowland gorilla is the most numerous and widespread of all gorilla subspecies. Populations can be found in Cameroon, the Central African Republic, the Democratic Republic of Congo and Equatorial Guinea as well as in large areas in Gabon and the Republic of Congo. The exact number of western lowland gorillas is not known because they inhabit some of the most dense and remote rainforests in Africa. Significant populations still exist, including in isolated swamps and the remote swampy forests of the Republic of Congo.\n" +
                    "\n" +
                    "Western lowland gorillas can be distinguished from other gorilla subspecies by their slightly smaller size, their brown-grey coats and auburn chests. They also have wider skulls with more pronounced brow ridges and smaller ears. Large numbers have not protected the western lowland gorilla from decline. Because of poaching and disease, the gorilla’s numbers have declined by more than 60% over the last 20 to 25 years. Even if all of the threats to western lowland gorillas were removed, scientists calculate that the population would require some 75 years to recover.\n",
            "The Yangtze River, the longest river in Asia, used to be one of the only two rivers in the world that was home to two different species of dolphin—the Yangtze finless porpoise and the Baiji dolphin. However, in 2006 the Baiji dolphin was declared functionally extinct. This was the first time in history that an entire species of dolphin had been wiped off the planet because of human activity. Its close cousin, the Yangtze finless porpoise, is known for its mischievous smile and has a level of intelligence comparable to that of a gorilla.\n"};


    String[] status = {"STATUS\n" +
            "Critically Endangered\n" +
            "POPULATION\n" +
            "More than 84 individuals\n" +
            "SCIENTIFIC NAME\n" +
            "Panthera pardus orientalis\n" +
            "WEIGHT\n" +
            "70 -105 pounds\n" +
            "HABITATS\n" +
            "Temperate, Broadleaf, and Mixed Forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "More than 5,500\n" +
                    "SCIENTIFIC NAME\n" +
                    "Diceros bicornis\n" +
                    "HEIGHT\n" +
                    "5.2 feet\n" +
                    "WEIGHT\n" +
                    "1,760 -3,080 pounds\n" +
                    "HABITATS\n" +
                    "Semi-Desert Savannah, Woodlands, Forests, Wetlands",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "About 104,700\n" +
                    "SCIENTIFIC NAME\n" +
                    "Pongo pygmaeus\n" +
                    "HEIGHT\n" +
                    "3.3 – 4.6 feet\n" +
                    "WEIGHT\n" +
                    "66–220 pounds\n" +
                    "HABITATS\n" +
                    "Lowland rainforests and tropical, swamp and mountain forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "200 to 300 individuals\n" +
                    "SCIENTIFIC NAME\n" +
                    "Gorilla gorilla diehli\n" +
                    "HEIGHT\n" +
                    "4 to 5 ½ feet when standing on two feet\n" +
                    "WEIGHT\n" +
                    "up to 440 pounds",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "Unknown\n" +
                    "SCIENTIFIC NAME\n" +
                    "Gorilla beringei graueri\n" +
                    "HEIGHT\n" +
                    "4 to 5 ½ feet tall when standing on two feet\n" +
                    "WEIGHT\n" +
                    "up to 440 pounds",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "SCIENTIFIC NAME\n" +
                    "Eretmochelys imbricata\n" +
                    "WEIGHT\n" +
                    "90-150 pounds\n" +
                    "LENGTH\n" +
                    "30-35 inches\n" +
                    "HABITATS\n" +
                    "Oceans\n",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "58–68\n" +
                    "SCIENTIFIC NAME\n" +
                    "Rhinoceros sondaicus\n" +
                    "HEIGHT\n" +
                    "4.6–5.8 feet\n" +
                    "WEIGHT\n" +
                    "1,984 - 5,071 pounds\n" +
                    "LENGTH\n" +
                    "10–10.5 feet\n" +
                    "HABITATS\n" +
                    "Tropical forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "about 104,700 (Bornean), 13,846 (Sumatran), 800 (Tapanuli)\n" +
                    "SCIENTIFIC NAME\n" +
                    "Pongo abelii, Pongo pygmaeus\n" +
                    "WEIGHT\n" +
                    "up to 200 pounds",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "Unknown\n" +
                    "SCIENTIFIC NAME\n" +
                    "Pseudoryx nghetinhensis\n" +
                    "HEIGHT\n" +
                    "Average 33 inches at the shoulder\n" +
                    "WEIGHT\n" +
                    "176-220 lbs\n" +
                    "HABITATS\n" +
                    "Evergreen forests with little or no dry season\n",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "2,400 – 2,800\n" +
                    "SCIENTIFIC NAME\n" +
                    "Elephas maximus sumatranus\n" +
                    "HEIGHT\n" +
                    "5-9 feet at the shoulder\n" +
                    "WEIGHT\n" +
                    "approximately 5 tons\n" +
                    "LENGTH\n" +
                    "up to 20 feet\n" +
                    "HABITATS\n" +
                    "Broadleaf moist tropical forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "14,613\n" +
                    "SCIENTIFIC NAME\n" +
                    "Pongo abelii\n" +
                    "WEIGHT\n" +
                    "66 – 198 pounds\n" +
                    "LENGTH\n" +
                    "4 -5 feet\n" +
                    "HABITATS\n" +
                    "Tropical and Subtropical Moist Broadleaf Forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "80\n" +
                    "SCIENTIFIC NAME\n" +
                    "Dicerorhinus sumatrensis\n" +
                    "HEIGHT\n" +
                    "3.3-5 feet\n" +
                    "WEIGHT\n" +
                    "1,320 -2,090 pounds\n" +
                    "LENGTH\n" +
                    "6.5-13 feet\n" +
                    "HABITATS\n" +
                    "Dense highland and lowland tropical and sub-tropical forests",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "Less than 400\n" +
                    "SCIENTIFIC NAME\n" +
                    "Panthera tigris sondaica\n" +
                    "WEIGHT\n" +
                    "165–308 pounds\n" +
                    "HABITATS\n" +
                    "Tropical broadleaf evergreen forests, freshwater swamp forests and peat swamps",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "About 10 individuals\n" +
                    "SCIENTIFIC NAME\n" +
                    "Phocoena sinus\n" +
                    "HEIGHT\n" +
                    "Up to 5 feet\n" +
                    "WEIGHT\n" +
                    "Up to 120 pounds\n" +
                    "HABITATS\n" +
                    "Marine (only in the northern Gulf of California)",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "Unknown\n" +
                    "SCIENTIFIC NAME\n" +
                    "Gorilla gorilla gorilla\n" +
                    "HEIGHT\n" +
                    "4 to 5 ½ feet when standing on two feet\n" +
                    "WEIGHT\n" +
                    "up to 440 pounds",
            "STATUS\n" +
                    "Critically Endangered\n" +
                    "POPULATION\n" +
                    "1000-1800\n" +
                    "SCIENTIFIC NAME\n" +
                    "Neophocaena asiaeorientalis ssp. asiaeorientalis\n" +
                    "LENGTH\n" +
                    "6.2 feet\n" +
                    "HABITATS\n" +
                    "Lakes & Rivers"};

}

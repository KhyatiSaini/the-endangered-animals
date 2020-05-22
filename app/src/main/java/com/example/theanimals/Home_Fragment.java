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
        Intent intent = new Intent(getContext(), InfoActivity.class);
        intent.putExtra("ImageURL", homeModel.getAnimalImageResource());
        intent.putExtra("AnimalName", homeModel.getNameOfAnimal());
        intent.putExtra("AnimalInfo", info[position]);
        intent.putExtra("AnimalStatus", status[position]);
        intent.putExtra("AnimalOtherInfo", otherInfo[position]);
        Log.e("inside SAH", "info : " + String.valueOf(info.length));
        startActivity(intent);
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

    String[] otherInfo = {"Why they matter?\n" +
                    "The Amur leopard is important ecologically, economically and culturally. Conservation of its habitat benefits other species, including Amur tigers and prey species like deer. With the right conservation efforts, we can bring them back and ensure long-term conservation of the region.\n" +
                    "\n" +
                    "THREATS\n" +
                    "\n" +
                    "ILLEGAL WILDLIFE TRADE\n" +
                    "The Amur leopard is poached largely for its beautiful, spotted fur. In 1999, an undercover investigation team recovered a female and a male Amur leopard skin, which were being sold for $500 and $1,000 respectively in the village of Barabash, not far from the Kedrovaya Pad reserve in Russia. Agriculture and villages surround the forests where the leopards live. As a result the forests are relatively accessible, making poaching a problem—not only for the leopards themselves, but also for important prey species, such as roe deer, sika deer and hare, which are hunted by the villagers both for food and cash.\n" +
                    "\n" +
                    "PREY SCARCITY\n" +
                    "There are still large tracts of suitable habitat left across the Amur in Russia and China. In China the prey base is insufficient to sustain large populations of leopards and tigers. Prey populations will recover if measures are taken to limit the poaching of prey species and the forests are managed for logging more sustainably. For the Amur leopard to survive for the long term, it needs to repopulate its former range. But for that to happen, prey populations need to recover first.\n",
                    "Why they matter?\n" +
                    "Rhinos are one of the oldest groups of mammals, virtually living fossils. They play an important role in their habitats and in countries like Namibia, rhinos are an important source of income from ecotourism. The protection of black rhinos creates large blocks of land for conservation purposes. This benefits many other species, including elephants.\n" +
                    "\n" +
                    "THREATS\n" +
                    "\n" +
                    "ILLEGAL WILDLIFE TRADE\n" +
                    "Of all the threats facing black rhinos, poaching is the deadliest. Black rhinos have two horns which make them lucrative targets for the illegal trade in rhino horn A wave of poaching for rhino horn rippled through Kenya and Tanzania, continued south through Zambia's Luangwa Valley as far as the Zambezi River, and spread into Zimbabwe. Political instability and wars have greatly hampered rhino conservation work in Africa, notably in Angola, Rwanda, Somalia, and Sudan. This situation has exacerbated threats such as trade in rhino horn and increased poaching due to poverty.\n" +
                    "\n" +
                    "Today, black rhinos remain critically endangered because of rising demand for rhino horn, from some Asian consumers, particularly in Vietnam and China, who use them in folk remedies. A recent increase in poaching in South Africa threatens to erase our conservation success, reaching an apex in 2014 when 1,215 rhinos were poached. Poaching numbers are slowly decreasing—1,054 were poached in 2016—but poaching continues unabated with numbers remaining unsustainably high.\n" +
                    "\n" +
                    "POPULATION DENSITY, DISEASE, AND INBREEDING\n" +
                    "High population density in some sites leads to lower breeding rates and increases the probability of disease transmission. Smaller, isolated populations can also be prone to genetic impacts from inbreeding.\n" +
                    "\n" +
                    "HABITAT LOSS AND FRAGMENTATION\n" +
                    "Next to poaching, loss of habitat contributes to declines in rhino population. Human activities such as agriculture, settlements, and infrastructure development result in the loss and fragmentation of rhino habitat, which increases the risk of poaching and inbreeding.\n",
                    "Why they matter?\n" + "Orangutans play a critical role in seed dispersal, keeping forests healthy. Over 500 plant species have been recorded in their diet.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "Orangutan numbers and distribution have declined rapidly since the middle of the 20th century, due to human activities. These include hunting, unsustainable and often illegal logging, mining, and conversion of forests to agriculture. One particularly catastrophic event was the 1997-98 forest fires in Kalimantan, which killed up to 8,000 individual orangutans.\n" +
                            "\n" +
                            "ILLEGAL WILDLIFE TRADE\n" +
                            "Young orangutans are in demand for a flourishing pet trade, with each animal fetching several hundred dollars in city markets on nearby islands. Studies have indicated that 200-500 orangutans from Indonesian Borneo alone enter the pet trade each year. This represents a real threat to wild orangutan populations as orangutans have an extremely low reproductive rate. There is also trade in orangutan parts in Kalimantan, with orangutan skulls fetching up to $70 in towns\n" +
                            "\n" +
                            "CONFLICT WITH HUMANS\n" +
                            "Orangutans are sometimes shot in retaliation when they move into agricultural areas, such as oil palm plantations, and destroy crops. This occurs particularly in times of hardship when orangutans can’t find the food they need in the forest.\n",
                    "THREATS\n" +
                            "\n" +
                            "HUNTING\n" +
                            "The hunting and killing of gorillas is illegal in Cameroon and Nigeria, but enforcement of wildlife laws is often lax. Following conservation efforts, hunting has declined to a low level, but any amount of gorilla killing will have a significantly impact an already small population.\n" +
                            "\n" +
                            "INBREEDING\n" +
                            "The population risks inbreeding and a loss of genetic diversity because there are so few Cross River gorillas and they live in groups that interact infrequently if at all.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "A QUICKLY DISAPPEARING SUBSPECIES\n" +
                            "The eastern lowland gorilla’s range has declined by at least a quarter over the last 50 years. The last census, in the mid-1990s, estimated that there were only 16,900 of the animals left in the wild, but following more than a decade of habitat destruction and fragmentation and years of civil unrest, the eastern lowland gorilla’s population may have declined by half or more.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "HABITAT LOSS AND FRAGMENTATION\n" +
                            "As humans have moved from high-density regions in the East into the gorilla’s territory, they have destroyed and fragmented much of the animal’s forest habitat to make room for farming and livestock. Only a small portion of the gorilla’s range lies in protected areas such as Kahuzi-Biega National Park. But even there, park rangers often find it difficult to patrol the borders and protect the gorillas.\n" +
                            "\n" +
                            "MINING\n" +
                            "Illegal mining for tin, gold, diamond and, especially, coltan—an alloy used in cell phones—is widespread throughout the eastern lowland gorilla’s range. This mining has helped to fuel the civil unrest in the region and attracted migrants who hunt the animals for bushmeat, medicine and the capture and trade of infant gorillas.\n" +
                            "\n" +
                            "CIVIL UNREST\n" +
                            "Years of political instability and conflict have left the Congolese network of national parks in a state of neglect. Humans have been able to encroach upon Kahuzi-Biega National Park to hunt gorillas and to set up illegal mines. In addition, military activity and the presence of heavy weaponry have contributed to unrest in the region that has made conservation efforts difficult.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "Hawksbills help maintain the health of coral reefs. As they remove prey such as sponges from the reef's surface, they provide better access for reef fish to feed.  They also have cultural significance and tourism value.  For example, for local residents in the Coral Triangle, the flow of visitors who come to admire turtles is a vital source of income.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "Like other sea turtles, hawksbills are threatened by the loss of nesting and feeding habitats, excessive egg collection, fishery-related mortality, pollution, and coastal development. However, they are most threatened by wildlife trade.\n" +
                            "\n" +
                            "ILLEGAL WILDLIFE TRADE\n" +
                            "\n" +
                            "Turtle shell\n" +
                            "The shell trade for tourists is a serious threat to Madagascar's marine resources.\n" +
                            "\n" +
                            "Despite their current protection under the Convention on International Trade in Endangered Species of Wild Fauna and Flora (CITES) and many national laws, there is still a disturbingly large amount of illegal trade in hawksbill shells and products. They are much sought after throughout the tropics for their beautiful brown and yellow carapace plates that are manufactured into tortoiseshell items for jewelry and ornaments. In recent decades, eastern Asia has provided an eager market for tortoiseshell.\n" +
                            "\n" +
                            "FISHERIES BYCATCH\n" +
                            "Hawksbills are particularly susceptible to entanglement in gillnets and accidental capture on fishing hooks. Sea turtles need to reach the surface to breathe, and therefore many drown once caught. Known as bycatch, this is a serious threat to hawksbill turtles. As fishing activity expands, this threat is more of a problem.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "The population in Ujung Kulon National Park represents the only hope for the survival of a species that is on the brink of extinction. Until the late 19th century and early 20th century, Javan rhinos existed from northeast India and the Sunderbans , throughout mainland Southeast Asia, and on the island of Sumatra. If we lose the population in Java, the entire species will disappear.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "Javan rhinos are found in only one protected area in the world. The biology of the species is poorly understood, but we are starting to learn more about the species ecology and behavior thanks to very intensive monitoring of the population. They are extremely vulnerable to extinction due to natural catastrophes, habitat loss, diseases, poaching, and potential inbreeding.\n" +
                            "\n" +
                            "REDUCED GENETIC DIVERSITY\n" +
                            "The small size of the Javan rhino population is a cause for concern. Low genetic diversity and inbreeding could make it difficult for the long-term survival of the species.\n" +
                            "\n" +
                            "NATURAL DISASTERS\n" +
                            "The coastal Ujung Kulon National Park is highly vulnerable to tsunamis, and a major explosion of the nearby Anak Krakatau volcano could easily wipe out most life in the protected area. Rising sea levels because of climate change also threaten the park.\n" +
                            "\n" +
                            "ARENGA PALM\n" +
                            "The Arenga palm has overtaken parts of the park, reducing natural forage and habitat quality.\n" +
                            "\n" +
                            "DISEASE\n" +
                            "In recent years four rhinos, including one young adult female, are thought to have died from disease, probably transmitted to wild cattle in the park and subsequently to the rhinos.\n" +
                            "\n" +
                            "HABITAT DEGRADATION\n" +
                            "People living near the park are encroaching on and degrading crucial rhino habitat. Important economic development near the park, including from (eco)tourism, risks further encroachment into the park.\n" +
                            "\n" +
                            "ILLEGAL WILDLIFE TRADE\n" +
                            "Javan rhinos were killed by trophy hunters during colonial times. They were also killed as agricultural pests and for their horn, a highly prized commodity in traditional Asian medicine. Poaching remains an ever-present threat\n",
                    "Why they matter?\n" +
                            "\n" +
                            "Orangutans are \"gardeners\" of the forest, playing a vital role in seed dispersal in their habitats. They live in tropical forests and prefer forest in river valleys and floodplains of their respective islands. Orangutans' extremely low reproductive rate makes their populations highly vulnerable. Females give birth to one infant at a time about every 3-5 years, so these species can take a long time to recover from population declines. With human pressure only increasing, orangutans face an increasing risk of extinction.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "HUNTING AND ILLEGAL WILDLIFE TRADE\n" +
                            "Orangutans are an easy target for hunters because they're large and slow targets. They are killed for food or in retaliation when they move into agricultural areas and destroy crops. This usually occurs when orangutans can't find the food they need in the forest.\n" +
                            "\n" +
                            "Females are hunted most often. When caught with offspring, the young are often kept as pets. The pet trade is a major problem. It is thought that for each orangutan reaching Taiwan, as many as 3-5 additional animals die in the process. Recent enforcement of the law in Taiwan has reduced the importation of orangutans, but the trade remains a threat in Indonesia where there is still demand for orangutans as pets. There is also trade in orangutan skulls in Kalimantan (Indonesian Borneo)\n" +
                            "\n" +
                            "DEFORESTATION AND HABITAT LOSS\n" +
                            "The habitats of Asia's only great apes are fast disappearing under the chainsaw to make way for oil palm plantations and other agricultural plantations. Illegal logging inside protected areas and unsustainable logging in concessions where orangutans live remains a major threat to their survival. Today, more than 50% of orangutans are found outside protected areas in forests under management by timber, palm oil and mining companies\n",
                    "Why they matter?\n" +
                            "\n" +
                            "The actual size of the remaining population is unknown. Its rarity, distinctiveness and vulnerability make it one of the greatest priorities for conservation in the region. The current population is thought to be a few hundred at a maximum and possibly only a few dozen at a minimum. \n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "With its unusually long horns and white markings on the face, the saola is a strong symbol for biodiversity in Lao and Vietnam.\n" +
                            "\n" +
                            "HABITAT LOSS\n" +
                            "As forests disappear under the chainsaw to make way for agriculture, plantations and infrastructure, saola are being squeezed into smaller spaces. The added pressure from rapid and large-scale infrastructure in the region is also fragmenting saola habitat. Conservationists are concerned that this is allowing hunters easy access to the once untouched forest of the saola and may reduce genetic diversity in the future.\n" +
                            "\n" +
                            "HUNTING\n" +
                            "Saola are often caught in snares set in the forest for wild boar, sambar or muntjac deer. Local villagers set some snares for subsistence use and crop protection. Recent increases in lowland people hunting to supply the illegal trade in wildlife has led to a massive increase in hunting, driven by traditional medicine demand in China and restaurant and food markets in Vietnam and Laos.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "Sumatran elephants feed on a variety of plants and deposit seeds wherever they go, contributing to a healthy forest ecosystem.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "DEFORESTATION AND HABITAT LOSS\n" +
                            "In 2012, the Sumatran elephant was changed from “Endangered” to “Critically Endangered” because half of its population has been lost in one generation—a decline that is largely due to habitat loss and as a result human-elephant conflict. Sumatra has experienced one of the highest rates of deforestation within the Asian elephant’s range, which has resulted in local extinctions of elephants in many areas. Over two-thirds of its natural lowland forest has been razed in the past 25 years and nearly 70 percent of the Sumatran elephant’s habitat has been destroyed in one generation.\n" +
                            "\n" +
                            "In Sumatra’s Riau province, pulp and paper industries and oil palm plantations have caused some of the world’s most rapid rates of deforestation. Elephant numbers have declined by a staggering 80 percent in less than 25 years, confining some herds to small forest patches. These populations are not likely to survive in the long-term. The Lampung province has seen its number of elephant herds decline from twelve in the 1980s to only three by 2002. Just two of the remaining herds are considered biologically viable.\n" +
                            "\n" +
                            "HUMAN-ELEPHANT CONFLICT\n" +
                            "As a result of the rapid development and deforestation in Sumatra, elephants often come into contact with human settlements. They raid crops, trample homes and sometimes even hurt or kill people. Those affected sometimes retaliate and poison or shoot elephants.\n" +
                            "\n" +
                            "POACHING\n" +
                            "Sumatran elephants typically have smaller tusks but they are enough to tempt poachers who kill the animals and sell their tusks on the illegal ivory market. Only male Asian elephants have tusks so every poaching event further skews the sex ratio further constraining breeding rates for the species.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "Orangutans are frugivores and play a vital role in the dispersal of seeds over a huge area. If orangutans were to disappear, so would several tree species, especially those with larger seeds.\n" +
                            "\n" +
                            "The tropical rainforests where Sumatran orangutans live are also home to other spectacular species including rare Sumatran tigers, Sumatran elephants, and Sumatran rhinoceroses.\n" +
                            "\n" +
                            "The forests orangutans call home are a vital source for fresh water. Rivers and streams from these forests provide local communities with water for drinking, cooking, bathing, irrigation and hydroelectricity. The forests are also a valuable source for wildlife products like honey and rattan\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "HABITAT LOSS\n" +
                            "Orangutan habitat in north Sumatra is being lost at an extremely high rate, mainly due to fire and conversion of forests to oil palm plantations and other agricultural development. This species depends on high-quality forests. Widespread forest fires, many set deliberately to clear land for plantations, are becoming a regular disaster. Not only do fires destroy vast areas of orangutan habitat, but thousands of these slow-moving apes are thought to have burned to death, unable to escape the flames.\n" +
                            "\n" +
                            "A plan to build a major road in northern Sumatra threatens one of the largest-remaining areas of the orangutan’s habitat. Not only will the road fragment the forest, but it will also open up access for illegal logging activities and human settlements. The project is progressing despite proof that conserving the region will help long-term sustainable development.\n" +
                            "\n" +
                            "HUNTING\n" +
                            "Despite legal protection in Indonesia since 1931, orangutans are still captured from the wild and kept in households as status symbols. In some areas orangutans are hunted for food. Investigations by TRAFFIC, the global wildlife monitoring network, shows that lack of law enforcement against this illegal trafficking poses a serious threat to orangutans. Females give birth to just one infant at a time every eight or nine years, making their populations very susceptible to even very low levels of hunting. Experts estimate that even as little as 1% of females lost each year through hunting or other unnatural causes could put a population on an irreversible trajectory to extinction.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "In all rhino conservation areas, there are other valuable plants and animals. Protecting rhinos helps maintain other animal and plant life in the area and keeps ecosystems healthy.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "Growing consumer demand for rhino horn has driven the unsustainable increase in poaching across Africa and Asia. Rhino horn is coveted in parts of Asia for its purported medicinal qualities and as an ornament, often carved, which connotes social status and prestige.\n" +
                            "\n" +
                            "China and Vietnam are the two largest consumer markets for rhino horn. Demand in China began escalating in the 1990s in tandem with booming economic growth. Investigations by TRAFFIC, the world’s largest wildlife trade monitoring network, and WWF reveal that use of rhino horn in traditional medicine persists in many countries.\n" +
                            "\n" +
                            "HABITAT LOSS\n" +
                            "Sumatran rhino habitat is being lost or degraded by invasive species, road construction, and encroachment for agricultural expansion. For example, Bukit Barisan Selatan National Park in Sumatra is losing forest cover due to conversion for coffee and rice by illegal settlers.\n" +
                            "\n" +
                            "LACK OF PROTECTION\n" +
                            "Protection is insufficient in existing protected areas. When rhinos move outside of protected areas, communities are not sufficiently engaged or incentivized to protect them.\n" +
                            "\n" +
                            "SMALL POPULATION SIZE AND ISOLATION\n" +
                            "Due to small numbers, low probability of breeding pairs encountering one other, and reproductive problems among aging females, we believe breeding among wild Sumatran rhinos to be minimal in most locations. Most—if not all—of the remaining sub-populations are too small to be viable long-term breeding populations.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "The island of Sumatra is the only place where tigers, rhinos, orangutans, and elephants live together in the wild. The presence of the Sunda tiger is an important indicator of a forest's health and biodiversity. Protecting tigers and their habitat means many other species benefit—including people.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "ILLEGAL WILDLIFE TRADE\n" +
                            "Most tigers in Sumatra are killed deliberately for commercial gain. According to a survey from TRAFFIC, the global wildlife trade monitoring network, poaching for trade is responsible for almost 80% of estimated Sumatran tiger deaths—amounting to at least 40 animals per year.\n" +
                            "\n" +
                            "Despite intensified conservation and protection measures in parts of Sumatra and some success in curtailing markets for tiger bone, there is little evidence that tiger poaching has declined significantly on the island since the early 1990s.\n" +
                            "\n" +
                            "HUMAN-WILDLIFE CONFLICT\n" +
                            "Dispersal of tigers in search of their territory and habitat destruction forces tigers out of protected areas and into human-occupied spaces— where they are more likely to come into conflict with people. Like other parts of the tiger’s range, human-tiger conflict is a serious problem in Sumatra. People have been killed or wounded, and livestock falls prey to tigers. Retaliatory action by villagers can result in the killing of tigers.\n" +
                            "\n" +
                            "HABITAT LOSS\n" +
                            "Habitat for the Sumatran tiger has been drastically reduced by clearing for agriculture (particularly oil palm), plantations, and settlement. On many parts of the island, illegal timber harvesting, and forest conversion are out of control. Between 1985 and 2014, the island’s forest cover plunged from 58% to 26%. Even protected areas face problems. In addition, forest conversion has isolated national parks from one another, along with populations of species like tigers that need large areas for breeding, feeding, and dispersing.\n",
                    "Why they matter?\n" +
                            "\n" +
                            "The vaquita is the most endangered cetacean in the world. With as few as around 10 left, the species will become extinct without a fully enforced gillnet ban throughout their entire habitat. WWF is urgently working to ensure they can live and thrive in their natural habitat.\n" +
                            "\n" +
                            "THREATS\n" +
                            "\n" +
                            "The vaquita will be extinct if fishery bycatch is not eliminated immediately. Nearly one out of every five vaquita get entangled and drown in gillnets intended for other marine species like the totoaba, a critically endangered fish also found in the upper Gulf of California. Entanglement in gillnets set for totoaba was the primary cause that brought the vaquita to low levels by the mid-1970s. Totoaba were overfished by the mid-1970s and were listed as endangered by Mexico in 1975, and by the US in 1979.\n" +
                            "\n" +
                            "Today, international trade in totoaba is banned under CITES, a global agreement among governments to regulate or ban international trade in species under threat, but high demand from China for its swim bladder has led to a boom in illegal totoaba fishing in the past few years. Demand for totoaba swim bladders has been driven by the belief in Chinese medicine that they are a cure to a variety of illness and diseases. Thousands of swim bladders are dried and smuggled out of Mexico, often through the United States. Fishermen receive around $4,000 for each pound of totoaba swim bladder, equivalent to half a year's income from legal fishing activities. It is this illegal trade that is currently driving the sharp decline in vaquita numbers.\n",
                    "THREATS\n" +
                            "\n" +
                            "DISEASE\n" +
                            "\n" +
                            "Central Africa is home to not only gorillas, but also the deadly Ebola virus. Ebola has caused a number of massive gorilla and chimpanzee die-offs in the remote forests at the heart of the primates’ ranges. Some scientists estimate that it has killed about one third of the wild gorilla population, mostly western lowland gorillas. The toll has been even greater in some areas, such as the Minkébé Forest—once considered one of the most important populations—where the virus may have killed more than 90% of the region’s gorillas and chimpanzees.\n" +
                            "\n" +
                            "POACHING\n" +
                            "The hunting and killing of gorillas is illegal but still the animals are killed for bushmeat or during the capture of baby gorillas for pets. In Northeast Congo, about 5% of western lowland gorillas in that region are killed each year. Timber and other companies have opened areas of once remote forest, facilitating poaching and the bushmeat trade. Poaching also carries dangers for humans as it is thought that Ebola may be spread through the butchering and handling of gorilla and other primate meat.\n",
                    "THREATS\n" +
                            "\n" +
                            "Finless porpoises need an abundant food supply for survival. The destruction of the Baiji dolphin food supply was central to its extinction. Overfishing is the main factor that contributes to the decrease in finless porpoises’ food supply, but pollution and ship movement are factors as well."};

}

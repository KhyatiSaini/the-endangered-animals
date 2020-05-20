package com.example.theanimals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
public class HomeActivity extends AppCompatActivity implements Adapter.SelectedAnimal {

    BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addingData();
        buildRecyclerView();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(list, getApplicationContext(), (Adapter.SelectedAnimal) this);
        recyclerView.setAdapter(adapter);
    }

    private void addingData() {
        list = new ArrayList<>();
        list.add(new Model(R.drawable.asianelephant, "Asian Elephant", "The IUCN’s best guess on the current population of Asian elephants, which inhabit 13 countries, is around 40,000–50,000. That number may be far lower; some regions inhabited by the lumbering pachyderms are inaccessible due to the terrain or to political volatility. Over 50% of the population is concentrated in India. The burgeoning human population there—and elsewhere in Asia—creates conflicts for space and resources. And while the tusks of Asian elephants are much smaller than those of their African counterparts, the Asian species is still poached for its ivory, meat, and skin", R.drawable.arrow));
        list.add(new Model(R.drawable.bluewhale, "Blue Whale", "There are fewer than 25,000 blue whales, the largest animals on the planet. Comprising several subspecies, blue whales are found in all of the world’s oceans save the Arctic. The current population is thought to have been reduced by up to 90% by whaling in the 20th century. Commercial hunting of the species was ultimately banned in 1966. The National Marine Fisheries Service of the U.S. spelled out a recovery plan in 1998. It stipulated the maintenance of photo databases of individual specimens and the collection of genetic and migration data in order to better understand the species, which remains at risk from ship collisions and entanglement in fishing nets.", R.drawable.arrow));
        list.add(new Model(R.drawable.giantpanda, "Giant Panda","Everyone loves a panda…they might be the kitschiest animal humanity has driven to the brink of extinction yet. From stuffed animals to martial arts-trained CGI abominations, we just can’t seem to get enough of the bi-colored beasts. Though their “aww factor” may verge on the cloying, it hasn’t been without effect. China, which is home to the remaining wild population of fewer than 2,500 individuals, has since the late 1980s instituted more stringent habitat protections and poaching has all but ceased. Their status is still tenuous, though. Their range is fragmented and they are still subject to disease, occasional predation, and starvation when large swathes of the bamboo on which they feed completes its life cycle and dies.", R.drawable.arrow));
        list.add(new Model(R.drawable.gorilla, "Gorilla", "Depending on who you ask, there are either two species of gorilla, the eastern (Gorilla beringei) and western (Gorilla gorilla), or three subspecies, the eastern lowland, western lowland, and mountain gorillas. Regardless of who you ask, all gorillas are endangered. There are probably only around 220,000 left in the wild. Habitat encroachment and poaching for bushmeat, trophies, and magical talismans have led to substantial losses. Because their social structure is so complex and because they reproduce slowly—with females only giving birth once every four years at best—the removal of even a few individuals from a gorilla troop can catastrophically impact its ability to sustain itself", R.drawable.arrow));
        list.add(new Model(R.drawable.whoopingcranes, "Whooping Cranes", "In 1938, the first year a population survey was conducted, only 29 whooping cranes remained in the wild. Three years later, only 16 were left. Hunting and reduction of their wetland habitat had vitiated the population and concerted efforts to salvage remnant birds did not being until the late 1960s. Today, there are over 400 birds, thanks in large part to innovative breeding programs. Though a plan that involved transferring whooping crane eggs to the nests of related sand-hill cranes for fostering ultimately failed, captive rearing and reintroduction have established two wild populations in Florida, one of which has been taught to migrate to Wisconsin. Neither is self-sustaining. The only self-sustaining population migrates between Alberta, Canada, and Texas, U.S.", R.drawable.arrow));
        list.add(new Model(R.drawable.orangutan, "Orangutan", "“Orangutan” is Malaysian for “person of the forest.” Though morphologically they may resemble melted Muppets more than people, their sophisticated cognitive abilities are very human indeed. Like gorillas and chimpanzees, they have been known to use tools. Due in large part to logging and capture for the exotic pet trade, orangutans—restricted to the Southeast Asian islands of Borneo and Sumatra—number fewer than 60,000 per a 2004 study. Unlike other great apes, they are usually solitary or live in groups of fewer than three, making them difficult to track and study.", R.drawable.arrow));
        list.add(new Model(R.drawable.seaotters, "Sea Otter", "The luxurious waterproof coat that insulates sea otters from the chilly waters that they inhabit almost led to its extinction. A target of the commercial fur trade, the species was almost wiped out, with only some 2,000 of an estimated 300,000 left by 1911. That year, an international ban on commercial hunting was enacted. Though that ban, along with management and conservation measures taken in the wake of the 1972 Marine Mammal Protection Act, have helped populations recover to perhaps a third of their earlier numbers, they are highly vulnerable to both natural phenomena such as killer whale predation and to anthropogenic factors such as oil spills.", R.drawable.arrow));
        list.add(new Model(R.drawable.siberiantiger, "Siberian Tiger", "William Blake’s “forests of the night,” the stalking grounds of the six subspecies of tiger, are burning bright. Slash-and-burn agriculture, along with logging, and human encroachment, have hugely diminished the habitat available to these felines, which require extensive ranges capable of supporting the large herbivores that constitute the bulk of their diets. Poaching—for trophies and body parts used in Asian “medicine” —is thought to pose the greatest threat to tigers. Probably fewer than 4,000 are left in the wild. In 2014, China explicitly outlawed the consumption of endangered species, including tigers, whose bones, penises, and other organs are superstitiously believed to have magical curative powers.", R.drawable.arrow));
        list.add(new Model(R.drawable.snowleopard, "Snow Leopard", "Though it’s called a leopard—and certainly resembles a frosted version of those spotted habitués of more equatorial regions—the snow leopard is actually more closely related to the tiger, at least per genetic analysis. Probably fewer than 6,500 remain in the wild, though due to the remote mountainous terrain preferred by the species, and its elusive nature, data is hard to come by. The largest populations are in China and Mongolia, with significant populations in India and Kyrgyzstan as well. Its natural prey include blue sheep and ibex, but in some areas, it is heavily dependent on domestic animals. The farmers who depend upon the animals shoot the “problem” leopards. Poaching still constitutes a major threat to the species, as does over-hunting of its natural prey species.", R.drawable.arrow));
        list.add(new Model(R.drawable.tasmaniandevil, "Tasmanian Devil", "Between 1996 and 2008, the population of Tasmanian devils dropped some 60% due a contagious cancer known as Devil Facial Tumour Disease. It continues to decimate populations of the species, which only occurs on the Australian island of Tasmania. There may only be 10,000 wild individuals remaining. Captive breeding of uninfected individuals has been instituted and efforts have been made to develop a vaccine for the cancer, which is thought to have stemmed from mutated cells from a single specimen.", R.drawable.arrow));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId())
                    {
                        case R.id.nav_home:
                            selectedFragment = new Home_Fragment();
                            break;
                        case R.id.nav_facts:
                            selectedFragment = new Facts_Fragment();
                            break;
                        case R.id.nav_stats:
                            selectedFragment = new Statistics_Fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public void selected(Model model, Context context) {
        Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
        intent.putExtra("ImageURL", model.getImageResource());
        intent.putExtra("AnimalName", model.getAnimalName());
        intent.putExtra("AnimalInfo", model.getInfo());
        startActivity(intent);
    }
}

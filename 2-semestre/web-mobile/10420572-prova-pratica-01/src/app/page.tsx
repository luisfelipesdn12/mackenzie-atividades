import Card from "./card";
import styles from "./page.module.css";
import { Product } from "./types";

const products: Product[] = [
  {
    name: "LEGO Disney e Pixar Casea de Up",
    image: "https://m.media-amazon.com/images/I/81x0LRtdD1L._AC_UF894,1000_QL80_.jpg",
    price: 529.99,
    promotion: true,
  },
  {
    name: "LEGO Architecture 21060",
    image: "https://m.media-amazon.com/images/I/81erlaRWyqL._AC_UF894,1000_QL80_.jpg",
    price: 1251.90,
    promotion: false,
  },
  {
    name: "LEGO My City 60380",
    image: "https://m.media-amazon.com/images/I/81AJdQfWqmL._AC_UF894,1000_QL80_.jpg",
    price: 1578.99,
    promotion: true,
  },
  {
    name: "LEGO Marvel Spider-man at the Sanctum Workshop",
    image: "https://i5.walmartimages.com/seo/LEGO-Marvel-Spider-Man-at-the-Sanctum-Workshop-76185-Building-Toy-Set-355-Pieces_cb972724-d20b-4e74-b976-009078f763bf.bdb3f0256eda439aa0a5772df14c8f31.jpeg",
    price: 278.74,
    promotion: true,
  },
];

export default function Home() {
  return (
    <main className={styles.main}>
      {products.map((product, index) => (
        <Card key={index} product={product} />
      ))}
    </main>
  );
}

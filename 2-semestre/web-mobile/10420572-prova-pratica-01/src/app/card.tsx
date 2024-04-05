import styles from "./page.module.css";
import { Product } from "./types";

interface CardProps {
    product: Product;
}

export default function Card({ product }: CardProps) {
  return (
    <section className={styles.card} style={product.promotion ? { borderLeftColor: "#ee4b4b" } : undefined}>
      <img src={product.image} alt={product.name} />
      <aside>
        <h1>{product.name}</h1>
        <p>{product.price.toLocaleString(undefined, { minimumFractionDigits: 2 , style: 'currency', currency: 'BRL' })} - {product.promotion ? "Promoção" : "Preço cheio"}</p>
      </aside>
    </section>
  );
}

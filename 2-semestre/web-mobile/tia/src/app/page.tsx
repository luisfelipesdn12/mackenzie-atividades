import VoteCard from "@/components/vote-card";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-center align-middle p-24 gap-4">
      <ul className="flex gap-4 flex-wrap justify-center items-center">
        {Array.from(Array(1).keys()).map(n => (
          <VoteCard key={n} />
        ))}
      </ul>
    </main>
  );
}

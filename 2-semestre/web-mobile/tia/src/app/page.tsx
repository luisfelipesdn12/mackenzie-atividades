"use client";

import TiaCard from "@/components/tia-card";


export default function Home() {
  const play = () => {
    var audio: HTMLAudioElement = document.getElementById("igor-audio") as HTMLAudioElement;
    audio.play();
  };

  return (
    <main onClick={() => play()} className="flex min-h-screen flex-col items-center justify-center align-middle p-24 gap-4">
      <audio id="igor-audio" src="/igor.mp3"></audio>
      <ul className="flex gap-4 flex-wrap justify-center items-center">
        {Array.from(Array(1).keys()).map(n => (
          <TiaCard key={n} />
        ))}
      </ul>
    </main>
  );
}

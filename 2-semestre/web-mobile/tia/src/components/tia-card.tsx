"use client";

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import {
    Card,
    CardContent,
    CardHeader
} from "@/components/ui/card";
import Image from "next/image";
import { useEffect, useState } from "react";
import ReactCardFlip from "react-card-flip";
import { Input } from "./ui/input";

export default function TiaCard() {
    const [selected, setSelected] = useState<boolean>();

    useEffect(() => {
        const id = setInterval(() => setSelected(s => !s), 4000);
        return () => clearInterval(id);
    }, []);

    return (
        <ReactCardFlip
            infinite={true}
            flipSpeedBackToFront={1}
            flipSpeedFrontToBack={1}
            isFlipped={selected} flipDirection="horizontal">
            <Card onClick={() => setSelected(true)} className="mack-card shadow-2xl bg-[#A03034] w-full flex flex-col justify-center items-center text-center">
                <CardHeader className="flex justify-center items-center py-2">
                    <Image alt="Mackenzie" src={"/logo_mack.png"} width={400} height={200} />
                </CardHeader>
                <CardContent className="flex">
                    <Avatar className="w-[9rem] h-[12rem] rounded-none">
                        <AvatarImage src="/icon.jpg" />
                        <AvatarFallback className="w-[9rem] h-[12rem] rounded-none">Imagem aqui</AvatarFallback>
                    </Avatar>
                    <aside className="w-80 h-[12rem] flex flex-col justify-between px-2">
                        <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"Tyler Okoma"} />
                        <div className="flex gap-2">
                            <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"0000000-0"} />
                            <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"12/2023"} />
                        </div>
                        <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"Sistemas de Informação"} />
                    </aside>
                </CardContent>
            </Card>
            <Card onClick={() => setSelected(true)} className="mack-card shadow-2xl bg-[#A03034] w-full flex flex-col justify-center items-center text-center">
                <CardHeader className="flex justify-center items-center py-2 opacity-0">
                    <Image alt="Mackenzie" src={"/logo_mack.png"} width={400} height={200} />
                </CardHeader>
                <CardContent className="flex opacity-0">
                    <Avatar className="w-[9rem] h-[12rem] rounded-none">
                        <AvatarImage src="/icon.jpg" />
                        <AvatarFallback className="w-[9rem] h-[12rem] rounded-none">Imagem aqui</AvatarFallback>
                    </Avatar>
                    <aside className="w-80 h-[12rem] flex flex-col justify-between px-2">
                        <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"Tyler Okoma"} />
                        <div className="flex gap-2">
                            <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"0000000-0"} />
                            <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"12/2023"} />
                        </div>
                        <Input readOnly className="text-center font-semibold text-xl h-12" type="text" value={"Sistemas de Informação"} />
                    </aside>
                </CardContent>
            </Card>
        </ReactCardFlip>
    );
}

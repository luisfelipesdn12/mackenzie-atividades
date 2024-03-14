"use client";

import { Avatar, AvatarImage } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader
} from "@/components/ui/card";
import { nanoid } from "nanoid";
import { useMemo, useState } from "react";

export default function VoteCard() {
    const id = useMemo(() => nanoid(), []);
    const [selected, setSelected] = useState<number>();

    return (
        <Card className="flex flex-col justify-center items-center text-center w-80">
            <CardHeader className="flex justify-center items-center gap-2">
                <Avatar className="bg-muted w-32 h-32 border">
                    <AvatarImage className="object-contain" src={`https://doodleipsum.com/700/avatar?n=${id}`} />
                </Avatar>
                <CardDescription>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque voluptate est similique, culpa quaerat.
                </CardDescription>
            </CardHeader>
            <CardContent>
                <ul className="flex gap-2">
                    {Array.from(Array(5).keys()).map(n => (
                        <Button
                            key={n}
                            size="icon" className="rounded-full"
                            onClick={() => setSelected(n)}
                            variant={selected === n ? "default" : "outline"}
                        >
                            {n+1}
                        </Button>
                    ))}
                </ul>
            </CardContent>
            <CardFooter>
                <Button size="lg" className="font-semibold">
                    Votar
                </Button>
            </CardFooter>
        </Card>
    );
}

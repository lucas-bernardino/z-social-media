import { Input } from "@/components/ui/input";
import { Search } from "lucide-react";

export default function PageSearch() {
  return (
    <div className="flex w-full items-center py-4">
      <Search className="relative left-10" />
      <Input placeholder="Busque alguém"
        className="pl-12 rounded-full text-lg"
      ></Input>
    </div>
  )
}

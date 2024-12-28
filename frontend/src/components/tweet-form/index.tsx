import SplitedContainer from "../splited-container";
import { Button } from "../ui/button";
import { Input } from "../ui/input";

export function TweetForm() {

  return (
    <SplitedContainer>
      <Input type="text"
        placeholder="O que está acontecendo?"
        className="rounded-none text-xl font-light border-0 border-b-2 border-muted w-full focus-visible:ring-0 focus-visible:border-0"></Input>
      <div className="flex justify-end">
        <Button className="w-32 rounded-full font-bold">Postar</Button>
      </div>
    </SplitedContainer>
  )

}
